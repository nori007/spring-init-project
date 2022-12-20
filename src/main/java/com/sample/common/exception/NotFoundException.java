package com.sample.common.exception;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;

public class NotFoundException extends BaseException {

    public NotFoundException(String message) {
        super(ErrorCodeEnum.NOT_FOUND_EXCEPTION, message);
    }

    public NotFoundException() {
        super(ErrorCodeEnum.NOT_FOUND_EXCEPTION);
    }

}
