package com.sample.common.excption;

public class InvalidArgumentException extends RuntimeException {

    public InvalidArgumentException(String message, Throwable t) {
        super(message, t);
    }

    public InvalidArgumentException(String message) {
        super(message);
    }

    public InvalidArgumentException(Throwable t) {
        super(t);
    }

    public InvalidArgumentException() {
        super("Invalid Argument Exception");
    }
}
