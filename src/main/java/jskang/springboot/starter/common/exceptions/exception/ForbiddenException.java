package jskang.springboot.starter.common.exceptions.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends CustomException {

    final HttpStatus httpStatus = HttpStatus.FORBIDDEN;

    public ForbiddenException() {
    }

    public ForbiddenException(String message) {
        super(message);
    }
}