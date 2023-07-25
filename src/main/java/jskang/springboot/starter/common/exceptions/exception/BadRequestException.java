package jskang.springboot.starter.common.exceptions.exception;

import org.springframework.http.HttpStatus;

public final class BadRequestException extends CustomException {

    final HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
