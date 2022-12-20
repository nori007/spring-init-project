package com.sample.common.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    DEFAULT_RUNTIME_EXCEPTION(HttpStatus.BAD_REQUEST, "ERROR0001"),
    DEFAULT_ACCESS_DENIED_EXCEPTION(HttpStatus.UNAUTHORIZED, "ERROR0002"),
    DEFAULT_INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR0003"),

    BAD_REQUEST_EXCEPTION(HttpStatus.BAD_REQUEST, "ERROR0010", "잘못된 요청입니다."),
    INVALID_ARGUMENT_EXCEPTION(HttpStatus.BAD_REQUEST, "ERROR0011", "유효하지 않은 매게 변수 입니다."),
    NOT_FOUND_EXCEPTION(HttpStatus.BAD_REQUEST, "ERROR0012", "해당 데이터를 찾을수 없습니다."),

    JWT_FORBIDDEN_EXCEPTION(HttpStatus.FORBIDDEN, "ERROR0100", "권한이 없습니다"),
    JWT_NOT_FOUND_ID_EXCEPTION(HttpStatus.BAD_REQUEST, "ERROR0101", "존재하지 않는 아이디 입니다."),
    JWT_DUPLICATED_EMAIL_EXCEPTION(HttpStatus.BAD_REQUEST, "ERROR0102", "중복된 메일 주소입니다."),
    JWT_INVALID_TOKEN_EXCEPTION(HttpStatus.BAD_REQUEST, "ERROR0103", "유효하지 않은 토큰 입니다."),
    JWT_TOKEN_EXPIRED_EXCEPTION(HttpStatus.UNAUTHORIZED, "ERROR0104", "토큰이 만료되었습니다.");

    private final HttpStatus status;
    private final String code;
    private String message;

    ErrorCodeEnum(HttpStatus status, String code) {
        this.status = status;
        this.code = code;
    }

}
