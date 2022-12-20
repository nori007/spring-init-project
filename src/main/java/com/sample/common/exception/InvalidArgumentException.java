package com.sample.common.exception;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;

public class InvalidArgumentException extends BaseException {

    public InvalidArgumentException(String message) {
        super(ErrorCodeEnum.INVALID_ARGUMENT_EXCEPTION, message);
    }

    public InvalidArgumentException() {
        super(ErrorCodeEnum.INVALID_ARGUMENT_EXCEPTION);
    }

}
