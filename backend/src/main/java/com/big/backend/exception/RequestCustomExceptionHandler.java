package com.big.backend.exception;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.ZonedDateTime;

@RestControllerAdvice
@ControllerAdvice
public class RequestCustomExceptionHandler {

    private int status;
    private HttpStatus httpStatus;
    private String message;


    @ExceptionHandler(value = {RequestCustomException.class})
    public ResponseEntity<Object> requestCustomExceptionHandler(RequestCustomException e) {
        return readException(e);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class, NoHandlerFoundException.class})
    public ResponseEntity<Object> handleGeneralException(Exception e) {
        return new ResponseEntity<>(new CustomException(
                "Server unavailable, please try again later!",
                HttpStatus.INTERNAL_SERVER_ERROR,
                500,
                ZonedDateTime.now()
        ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * creates Response entity to be returned
     *
     * @param e
     * @return
     */
    private ResponseEntity<Object> readException(RequestCustomException e) {
        this.message = e.getMessage();
        this.status = e.get_status();
        this.message = e.getMessage();

        switch (e.get_status()) {
            case 404: {
                this.httpStatus = HttpStatus.NOT_FOUND; // NOT FOUND
                break;
            }
            case 209: {
                this.httpStatus = HttpStatus.CONFLICT; // ALREADY EXISTS
                break;
            }
            default: {
                this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR; // IN CASE I DIDN'T PREDICT SUCH EXCEPTION
                this.status = 500;
                this.message = "Server error, please contact your administrator or try again later!";
                break;
            }
        }
        CustomException customException = new CustomException(
                this.message,
                this.httpStatus,
                this.status,
                ZonedDateTime.now());

        return new ResponseEntity<>(customException, httpStatus);
    }

}
