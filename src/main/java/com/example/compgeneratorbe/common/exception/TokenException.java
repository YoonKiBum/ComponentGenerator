package com.example.compgeneratorbe.common.exception;

import lombok.Getter;

@Getter
public class TokenException {

    private final String resultCode;
    private final String message;

    public TokenException(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }
}
