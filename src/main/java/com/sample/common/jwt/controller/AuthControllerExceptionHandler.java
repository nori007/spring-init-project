package com.sample.common.jwt.controller;

import com.sample.common.base.BaseControllerException;
import com.sample.common.jwt.excption.DuplicatedEmailExcption;
import com.sample.common.jwt.excption.InvalidTokenException;
import com.sample.common.jwt.excption.TokenExpiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class AuthControllerExceptionHandler extends BaseControllerException {

    @ExceptionHandler(DuplicatedEmailExcption.class)
    public ResponseEntity<String> duplicadEmailHandler(Exception ex) {
        return new ResponseEntity<>(String.format("duplicated email - %s", ex.getMessage()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<String> invalidTokenHandler(Exception ex) {
        return new ResponseEntity<>(String.format("invalid token - %s", ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(TokenExpiredException.class)
    public ResponseEntity<String> TokenExpiredHandler(Exception ex) {
        return new ResponseEntity<>(String.format("token expired - %s", ex.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
