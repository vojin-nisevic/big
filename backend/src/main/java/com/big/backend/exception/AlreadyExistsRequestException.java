package com.big.backend.exception;

public class AlreadyExistsRequestException extends RuntimeException{
    public AlreadyExistsRequestException(String message) {
        super(message);
    }
}
