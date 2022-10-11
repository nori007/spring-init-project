package com.sample.common.jwt.excption;

public class TokenExpiredException extends RuntimeException {

    public TokenExpiredException(String message, Throwable t) {
        super(message, t);
    }

    public TokenExpiredException(String message) {
        super(message);
    }

    public TokenExpiredException(Throwable t) {
        super(t);
    }

    public TokenExpiredException() {
        super("Token Expired Excption");
    }
}
