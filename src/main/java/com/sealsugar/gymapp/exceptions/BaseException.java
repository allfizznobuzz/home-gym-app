package com.sealsugar.gymapp.exceptions;

import lombok.Data;

@Data
public abstract class BaseException extends RuntimeException {

    private ErrorDetail errorDetail;
}
