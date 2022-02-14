package com.sealsugar.gymapp.exceptions;

import lombok.Data;

import java.util.Map;

@Data
public class ErrorDetail {

    private String code;
    private String description;
    private Map<String, String> details;
}
