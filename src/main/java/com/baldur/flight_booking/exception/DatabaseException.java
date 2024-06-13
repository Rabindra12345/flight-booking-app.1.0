package com.baldur.flight_booking.exception;

public class DatabaseException extends RuntimeException {
    private int statusCode;

    private String message;

    private String errorDescription;

    public DatabaseException(int statusCode, String errorDescription,String message) {
        this.statusCode = statusCode;
        this.errorDescription = errorDescription;
        this.message = message;
    }
}
