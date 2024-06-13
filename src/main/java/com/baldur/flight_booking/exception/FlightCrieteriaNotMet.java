package com.baldur.flight_booking.exception;

public class FlightCrieteriaNotMet extends RuntimeException{

    private int statusCode;

    private String message;

    private String errorDescription;

    public FlightCrieteriaNotMet(int statusCode, String errorDescription,String message) {
        this.statusCode = statusCode;
        this.errorDescription = errorDescription;
        this.message = message;
    }
}
