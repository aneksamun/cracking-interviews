package com.expedia.common;

import static java.lang.String.format;

public enum Error {
    HASH_COMPUTE_ERROR("Error computing hash: %s"),
    IMAGE_LOAD_ERROR("Error loading image: %s"),
    IMAGE_SAVE_ERROR("Error storing image: %s");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage(Object... args) {
        return format(message, args);
    }
}
