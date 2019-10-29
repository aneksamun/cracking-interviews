package co.uk.redpixel.storage.common;

import co.uk.redpixel.storage.domain.Image;
import co.uk.redpixel.storage.exception.InvalidImageFormatException;
import co.uk.redpixel.storage.exception.ServiceException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Path;

public final class ImageUtils {

    private ImageUtils() {}

    public static Image loadImage(File file) {
        try {
            ImageFormat format =
                    ImageFormat.find(getExtension(file))
                               .orElseThrow(InvalidImageFormatException::new);

            BufferedImage image = ImageIO.read(file);

            try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
                ImageIO.write(image, format.getExtension(), stream);
                stream.flush();
                return Image.of(stream.toByteArray(), format.getExtension());
            }

        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public static void saveImage(String id, Image image, Path path) {
        try {
            File file = new File(path.toString(), getFileName(id, image));
            try (InputStream in = new ByteArrayInputStream(image.getContent())) {
                BufferedImage bufferedImage = ImageIO.read(in);
                ImageIO.write(bufferedImage, image.getExtension(), file);
            }
        } catch (Exception e) {
            throw new ServiceException(e.getMessage());
        }
    }

    private static String getExtension(File file) {
        String fileName = file.getName();
        int index = fileName.lastIndexOf(".");
        return index > 0 ? fileName.substring(index + 1) : "";
    }

    private static String getFileName(String id, Image image) {
        return id + "." + image.getExtension();
    }
}
