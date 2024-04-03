package com.example.compgeneratorbe.common.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

    private final String errorMessage;
    private final String errorCode;
    private final HttpStatus httpStatus;


    public BusinessException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = HttpStatus.OK;
    }
}
