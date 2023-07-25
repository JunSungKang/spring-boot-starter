package jskang.springboot.starter.common.exceptions.exception;

public class CustomException extends RuntimeException {

    public CustomException() {}

    public CustomException(String message) {
        super(message);
    }
}
