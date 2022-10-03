package com.big.backend.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class NotFoundException {
    private final String message;
    private final HttpStatus httpStatus;



    private final int status;
    private final ZonedDateTime timestamp;

    public NotFoundException(String message, HttpStatus httpStatus, int status, ZonedDateTime timestamp) {
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

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

}
