package com.baldur.flight_booking.exception;

public class UserNotFoundException extends RuntimeException{

    private String message;

    private String errorDescription;

    private String errorCode;

    public UserNotFoundException(String message, String errorDescription, String errorCode) {
        this.message = message;
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }
}
