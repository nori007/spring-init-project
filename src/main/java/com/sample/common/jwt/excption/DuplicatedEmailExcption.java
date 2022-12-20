package com.sample.common.jwt.excption;

import com.sample.common.base.BaseException;
import com.sample.common.base.ErrorCodeEnum;

public class DuplicatedEmailExcption extends BaseException {

    public DuplicatedEmailExcption(String message) {
        super(ErrorCodeEnum.JWT_DUPLICATED_EMAIL_EXCEPTION, message);
    }

    public DuplicatedEmailExcption() {
        super(ErrorCodeEnum.JWT_DUPLICATED_EMAIL_EXCEPTION);
    }
}
