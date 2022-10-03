package com.big.backend.exception;

public class NotFoundRequestException extends RuntimeException{
    public NotFoundRequestException(String message) {
        super(message);
    }

}
