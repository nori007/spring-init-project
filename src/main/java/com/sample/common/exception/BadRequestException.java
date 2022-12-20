package com.sample.common.exception;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;

public class BadRequestException extends BaseException {

    public BadRequestException(String message) {
        super(ErrorCodeEnum.BAD_REQUEST_EXCEPTION, message);
    }

    public BadRequestException() {
        super(ErrorCodeEnum.BAD_REQUEST_EXCEPTION);
    }

}
