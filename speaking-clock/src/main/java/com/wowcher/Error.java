package com.wowcher;

import static java.lang.String.format;

public enum Error {
    UNRECOGNIZED_NUMBER("Cannot recognize %d"),
    ILLEGAL_TIME_FORMAT("Time must be provided in HH:mm format");

    private final String errorMessage;

    Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorMessage(Object... args) {
        return format(errorMessage, args);
    }
}
