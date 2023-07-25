package jskang.springboot.starter.common.exceptions.exception;

import org.springframework.http.HttpStatus;

public class ValidationException extends CustomException {

    final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }
}