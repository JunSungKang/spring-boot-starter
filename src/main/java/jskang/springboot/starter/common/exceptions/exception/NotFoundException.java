package jskang.springboot.starter.common.exceptions.exception;

import org.springframework.http.HttpStatus;

public final class NotFoundException extends CustomException {

    final HttpStatus httpStatus = HttpStatus.NOT_FOUND;

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
