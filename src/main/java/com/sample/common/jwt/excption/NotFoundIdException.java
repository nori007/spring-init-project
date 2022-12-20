package com.sample.common.jwt.excption;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;

public class NotFoundIdException extends BaseException {

    public NotFoundIdException(String message) {
        super(ErrorCodeEnum.JWT_NOT_FOUND_ID_EXCEPTION, message);
    }

    public NotFoundIdException() {
        super(ErrorCodeEnum.JWT_NOT_FOUND_ID_EXCEPTION);
    }
}
