package co.uk.redpixel.storage.domain;

import java.util.Arrays;
import java.util.Objects;

public class Image {

    private final String extension;

    private final byte[] content;

    private Image(byte[] content, String extension) {
        this.extension = extension;
        this.content = content;
    }

    public String getExtension() {
        return extension;
    }

    public byte[] getContent() {
        return content;
    }

    public static Image of(byte[] content, String extension) {
        return new Image(content, extension);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Image image = (Image) o;
        return Objects.equals(extension, image.extension) &&
                Arrays.equals(content, image.content);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(extension);
        result = 31 * result + Arrays.hashCode(content);
        return result;
    }
}
