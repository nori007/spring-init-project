package com.sample.common.jwt.excption;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;

public class InvalidTokenException extends BaseException {

    public InvalidTokenException(String message) {
        super(ErrorCodeEnum.JWT_INVALID_TOKEN_EXCEPTION, message);
    }

    public InvalidTokenException() {
        super(ErrorCodeEnum.JWT_INVALID_TOKEN_EXCEPTION);
    }
}
