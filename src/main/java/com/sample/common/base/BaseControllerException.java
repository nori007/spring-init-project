package com.sample.common.base;

import com.sample.common.excption.BadRequestException;
import com.sample.common.excption.InvalidArgumentException;
import com.sample.common.excption.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseControllerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestHandler(Exception ex) {
        return new ResponseEntity<>(String.format("bad request - %s", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<?> invalidArgumentHandler(Exception ex) {
        return new ResponseEntity<>(String.format("invalid argument - %s", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundHandler(Exception ex) {
        return new ResponseEntity<>(String.format("not found - %s", ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
