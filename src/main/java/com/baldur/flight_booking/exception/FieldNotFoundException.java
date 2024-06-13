package com.baldur.flight_booking.exception;

import org.springframework.http.HttpStatus;

public class FieldNotFoundException extends RuntimeException{

    private String message;

    private String errorDescription;

    private String errorCode;

    public FieldNotFoundException(String message, String errorDescription, String errorCode){
        this.message = message;
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }


}
