package com.wowcher;

class ClockServiceException extends RuntimeException {

    ClockServiceException(Error error, Throwable throwable) {
        super(error.getErrorMessage(), throwable);
    }

    ClockServiceException(Error error, Object... args) {
        super(error.getErrorMessage(args));
    }
}
