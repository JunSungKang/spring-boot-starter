package jskang.springboot.starter.common.exceptions.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends CustomException {

    final HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public InternalServerException() {
    }

    public InternalServerException(String message) {
        super(message);
    }
}
