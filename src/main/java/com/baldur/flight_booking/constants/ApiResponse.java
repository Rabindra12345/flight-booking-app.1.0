package com.baldur.flight_booking.constants;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
public class ApiResponse <T> {

    private String message;

    private String errorDescription;

    private int errorCode;

    T body;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    private ApiResponse( ) {
//        this.message = message;
    }

    public static <T> ApiResponse<T> forSuccess( int statusCode,T body){
        ApiResponse<T> apiResponse = new ApiResponse<>();
//        apiResponse.setMessage(message);
//        apiResponse.setErrorDescription(errorDesc);
        apiResponse.setErrorCode(statusCode);
        apiResponse.setBody(body);
        return apiResponse;
    }

    public static ApiResponse<?> forSuccessWithOutBody(String message, String errorDesc,int statusCode){
        ApiResponse<?> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(message);
        apiResponse.setErrorDescription(errorDesc);
        apiResponse.setErrorCode(statusCode);
        return apiResponse;
    }

    public static <T> ApiResponse<T> forErrorWithBody(String message, String errorDesc,int statusCode,T body){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(message);
        apiResponse.setErrorDescription(errorDesc);
        apiResponse.setErrorCode(statusCode);
        apiResponse.setBody(body);
        return apiResponse;
    }

    public static ApiResponse<?> forSuccessWithoutBody(int errorCode) {
        ApiResponse<?> apiResponse=new ApiResponse<>();
        apiResponse.setErrorCode(errorCode);
        return apiResponse;
    }

    public static<T> ApiResponse<T> forSuccessWithBody(String message, String errorDesc,int statusCode,T body){
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(message);
        apiResponse.setErrorDescription(errorDesc);
        apiResponse.setErrorCode(statusCode);
        apiResponse.setBody(body);
        return apiResponse;
    }


}
