package com.hammer.pulsar.exception;

public class DuplicateValueException extends RuntimeException {

    public DuplicateValueException() {}

    public DuplicateValueException(String message) {
        super(message);
    }
}
