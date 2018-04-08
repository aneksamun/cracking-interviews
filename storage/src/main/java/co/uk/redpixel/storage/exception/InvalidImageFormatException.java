package co.uk.redpixel.storage.exception;

import co.uk.redpixel.storage.common.ImageFormat;

public class InvalidImageFormatException extends RuntimeException {

    public InvalidImageFormatException() {
        super(buildErrorMessage());
    }

    private static String buildErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append("File should have ");

        ImageFormat[] values = ImageFormat.values();

        for (int i = 0; i < values.length; i++) {
            builder.append(values[i].getExtension());
            if (i + 1 < values.length) {
                builder.append(i + 2 == values.length ? " or " : ", ");
            }
        }

        builder.append(" extension.");

        return builder.toString();
    }
}
