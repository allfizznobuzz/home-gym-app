package com.sealsugar.gymapp.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseException extends RuntimeException {

    private final transient ErrorDetail errorDetail;

    protected BaseException(String message, Throwable cause, ErrorDetail errorDetail) {
        super(message, cause);
        this.errorDetail = errorDetail;
    }
}