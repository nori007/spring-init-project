package com.sample.common.jwt.excption;

public class InvalidTokenException extends RuntimeException {

    public InvalidTokenException(String message, Throwable t) {
        super(message, t);
    }

    public InvalidTokenException(String message) {
        super(message);
    }

    public InvalidTokenException(Throwable t) {
        super(t);
    }

    public InvalidTokenException() {
        super("Invalid Token Excption");
    }
}
