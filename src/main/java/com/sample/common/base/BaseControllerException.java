package com.sample.common.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class BaseControllerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(BaseException error) {
        return ResponseEntity
                .status(error.getError().getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(error.getError().getCode())
                        .errorMessage(error.getMessage().equals("") ? error.getError().getMessage() : error.getMessage())
                        .build());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(RuntimeException error) {
        return ResponseEntity
                .status(ErrorCodeEnum.DEFAULT_RUNTIME_EXCEPTION.getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ErrorCodeEnum.DEFAULT_RUNTIME_EXCEPTION.getCode())
                        .errorMessage(error.getMessage())
                        .build());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(AccessDeniedException error) {
        return ResponseEntity
                .status(ErrorCodeEnum.DEFAULT_ACCESS_DENIED_EXCEPTION.getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ErrorCodeEnum.DEFAULT_ACCESS_DENIED_EXCEPTION.getCode())
                        .errorMessage(error.getMessage())
                        .build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionEntity> exceptionHandler(Exception error) {
        return ResponseEntity
                .status(ErrorCodeEnum.DEFAULT_INTERNAL_SERVER_ERROR.getStatus())
                .body(ApiExceptionEntity.builder()
                        .errorCode(ErrorCodeEnum.DEFAULT_INTERNAL_SERVER_ERROR.getCode())
                        .errorMessage(error.getMessage())
                        .build());
    }
}
