package co.uk.redpixel.storage.exception;

import co.uk.redpixel.storage.common.Error;

public class ServiceException extends RuntimeException {

    public ServiceException(Error error) {
        this(error.getMessage());
    }

    public ServiceException(Error error, Throwable throwable) {
        super(error.getErrorMessage(throwable.getMessage()));
    }

    public ServiceException(Error error, Object... args) {
        super(error.getErrorMessage(args));
    }

    public ServiceException(String message) {
        super(message);
    }
}
