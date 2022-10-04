package com.big.backend.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class CustomException {

    private final String message;
    private final HttpStatus httpStatus;
    private final int status;
    private final ZonedDateTime timestamp;

    public CustomException(String message, HttpStatus httpStatus, int status, ZonedDateTime timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getStatus() {
        return status;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
