package com.sample.common.jwt.excption;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;

public class TokenExpiredException extends BaseException {

    public TokenExpiredException(String message) { super(ErrorCodeEnum.JWT_TOKEN_EXPIRED_EXCEPTION, message); }

    public TokenExpiredException() {
        super(ErrorCodeEnum.JWT_TOKEN_EXPIRED_EXCEPTION);
    }
}
