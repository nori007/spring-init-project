package com.sample.common.excption;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message, Throwable t) {
        super(message, t);
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(Throwable t) {
        super(t);
    }

    public BadRequestException() {
        super("Bad Request Exception");
    }
}
