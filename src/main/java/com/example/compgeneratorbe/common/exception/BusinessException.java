package com.example.compgeneratorbe.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    private final String errorType;
    private final String errorMessage;
    private final HttpStatus httpStatus;


    public BusinessException(String errorType, String message, HttpStatus httpStatus) {
        super(message);
        this.errorType = errorType;
        this.errorMessage = message;
        this.httpStatus = httpStatus;
    }
}
