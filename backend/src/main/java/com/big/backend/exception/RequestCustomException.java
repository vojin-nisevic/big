package com.big.backend.exception;

public class RequestCustomException extends RuntimeException{
    public int get_status() {
        return _status;
    }

    private int _status;

    public RequestCustomException(String message) {
        super(message);
    }

    public RequestCustomException(String message, int status) {
        super(message);
        this._status = status;
    }


}
