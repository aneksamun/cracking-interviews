package co.uk.redpixel.storage.common;

import java.util.Optional;

public enum ImageFormat {
    JPG("jpg"),
    GIF("gif"),
    PNG("png"),
    BMP("bmp"),
    JPEG("jpeg");

    private final String extension;

    ImageFormat(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

    public static Optional<ImageFormat> find(String extension) {
        for (ImageFormat format : values()) {
            if (extension.equalsIgnoreCase(format.extension)) {
                return Optional.of(format);
            }
        }
        return Optional.empty();
    }
}
