package com.baldur.flight_booking.exception;

public class UserNotFoundException extends RuntimeException{

    private String message;

    private String errorDescription;

    private int errorCode;

    public UserNotFoundException(String message, String errorDescription, int errorCode) {
        this.message = message;
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }
}
