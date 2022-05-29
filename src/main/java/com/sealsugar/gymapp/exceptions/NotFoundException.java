package com.sealsugar.gymapp.exceptions;

import lombok.Builder;

public class NotFoundException extends BaseException {

    @Builder
    public NotFoundException(String message, Throwable cause, ErrorDetail errorDetail) {
        super(message, cause, errorDetail);
    }
}
