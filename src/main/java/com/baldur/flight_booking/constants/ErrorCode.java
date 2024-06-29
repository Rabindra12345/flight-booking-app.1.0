package com.baldur.flight_booking.constants;

import lombok.Getter;
import org.springframework.http.HttpStatus;


//@Getter
public enum ErrorCode {

    OK(0,"OK", HttpStatus.OK ),
    NOT_FOUND(404,"Not Found", HttpStatus.NOT_FOUND),
    ALREADY_EXISTS(604,"Please Provide Another %S",HttpStatus.BAD_REQUEST);

    private final int statusCode;

    private final String message;

    private final HttpStatus httpStatus;

    ErrorCode(int statusCode, String message, HttpStatus httpStatus) {

        this.statusCode = statusCode;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}