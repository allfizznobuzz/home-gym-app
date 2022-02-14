package com.sealsugar.gymapp.exceptions;

import lombok.Data;

import java.util.Map;

@Data
public abstract class BaseException extends RuntimeException {

    private ErrorDetail errorDetail;
}
