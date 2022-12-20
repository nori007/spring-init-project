package com.sample.common.base;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiExceptionEntity {

    private String errorCode;
    private String errorMessage;

    @Builder
    public ApiExceptionEntity(HttpStatus status, String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
