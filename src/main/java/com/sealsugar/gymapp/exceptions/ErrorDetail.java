package com.sealsugar.gymapp.exceptions;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Map;

@Data
@Builder
public class ErrorDetail {

    private String code;
    private String description;
    @Singular
    private Map<String, String> details;
}
