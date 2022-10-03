package com.big.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = {NotFoundRequestException.class})
    public ResponseEntity<Object> handleNotFoundRequestException(NotFoundRequestException e){
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        int status = 404;
        NotFoundException notFoundException = new NotFoundException(e.getMessage(),
                notFound,
                404, ZonedDateTime.now());
        return new ResponseEntity(notFoundException, notFound);

    }

    @ExceptionHandler(value = {AlreadyExistsRequestException.class})
    public ResponseEntity<Object> handleAlreadyExistsRequestException(AlreadyExistsRequestException e) {
        HttpStatus alreadyExists = HttpStatus.CONFLICT;
        AlreadyExistsException alreadyExistsException = new AlreadyExistsException(e.getMessage(),
                alreadyExists,
                209,
        ZonedDateTime.now());
        return new ResponseEntity(alreadyExistsException, alreadyExists);
    }
}
