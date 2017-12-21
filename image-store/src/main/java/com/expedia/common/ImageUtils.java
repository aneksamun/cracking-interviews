package com.expedia.common;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.expedia.common.Error.IMAGE_LOAD_ERROR;
import static com.expedia.common.Error.IMAGE_SAVE_ERROR;

public final class ImageUtils {

    private ImageUtils() {}

    public static byte[] loadImage(String path) {
        try {
            return Files.readAllBytes(Paths.get(path));
        } catch (Exception e) {
            throw new ServiceException(IMAGE_LOAD_ERROR, e);
        }
    }

    public static void saveImage(byte[] image, String path) {
        try {
            try (InputStream in = new ByteArrayInputStream(image)) {
                BufferedImage bufferedImage = ImageIO.read(in);
                ImageIO.write(bufferedImage, "jpg", new File(path));
            }
        } catch (Exception e) {
            throw new ServiceException(IMAGE_SAVE_ERROR, e);
        }
    }
}
