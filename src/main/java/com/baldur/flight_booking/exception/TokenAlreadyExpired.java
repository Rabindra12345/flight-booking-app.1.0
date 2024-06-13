package com.baldur.flight_booking.exception;

public class TokenAlreadyExpired extends RuntimeException{

    private int statusCode;

    private String message;

    private String errorDescription;

    public TokenAlreadyExpired(int statusCode, String errorDescription,String message) {
        this.statusCode = statusCode;
        this.errorDescription = errorDescription;
        this.message = message;
    }
}
