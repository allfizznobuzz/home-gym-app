package com.sealsugar.gymapp.exceptions;

import lombok.Builder;

public class ValidationException extends BaseException {

    @Builder
    public ValidationException(String message, Throwable cause, ErrorDetail errorDetail) {
        super(message, cause, errorDetail);
    }
}
