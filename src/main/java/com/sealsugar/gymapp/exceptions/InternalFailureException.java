package com.sealsugar.gymapp.exceptions;

import lombok.Builder;

public class InternalFailureException extends BaseException {

    @Builder
    public InternalFailureException(String message, Throwable cause, ErrorDetail errorDetail) {
        super(message, cause, errorDetail);
    }
}
