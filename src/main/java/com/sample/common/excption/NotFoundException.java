package com.sample.common.excption;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable t) {
        super(t);
    }

    public NotFoundException() {
        super("Not Found Exception");
    }
}
