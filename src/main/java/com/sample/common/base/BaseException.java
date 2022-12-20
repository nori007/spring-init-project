package com.sample.common.base;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
    private ErrorCodeEnum error;
    private String message;

    public BaseException(ErrorCodeEnum error) {
        super(error.getMessage());
        this.error = error;
        this.message = error.getMessage();
    }

    public BaseException(ErrorCodeEnum error, String appendErrorMessage) {
        super(error.getMessage() + " (" + appendErrorMessage + ")");
        this.error = error;
        this.message = error.getMessage() + " (" + appendErrorMessage + ")";
    }
}
