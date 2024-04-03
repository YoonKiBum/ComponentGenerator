package com.example.compgeneratorbe.common.constants;

import com.example.compgeneratorbe.common.exception.BusinessException;

public final class BusinessExceptionType {

    private BusinessExceptionType() {}

    public static final String INVALID_JWT_SIGNATURE_EXCEPTION = "InvalidJwtSignature";
    public static final String EXPIRED_JWT_TOKEN_EXCEPTION = "ExpiredJwtToken";
    public static final String NOT_PROPERLY_EXECUTED_EXCEPTION = "NotProperlyExecuted";
    public static final String VALIDATION_EXCEPTION = "ValidationFailed";
}
