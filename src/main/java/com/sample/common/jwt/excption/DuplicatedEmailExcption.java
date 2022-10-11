package com.sample.common.jwt.excption;

public class DuplicatedEmailExcption extends RuntimeException{

    public DuplicatedEmailExcption(String message, Throwable t) {
        super(message, t);
    }

    public DuplicatedEmailExcption(String message) {
        super(message);
    }

    public DuplicatedEmailExcption(Throwable t) {
        super(t);
    }

    public DuplicatedEmailExcption() {
        super("Duplicated Email Exception");
    }
}
