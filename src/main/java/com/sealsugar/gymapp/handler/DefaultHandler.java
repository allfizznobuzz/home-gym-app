package com.sealsugar.gymapp.handler;

import com.sealsugar.gymapp.exceptions.ErrorDetail;
import com.sealsugar.gymapp.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorDetail> handleNotFoundException(NotFoundException exception) {
        return new ResponseEntity<ErrorDetail>(exception.getErrorDetail(), HttpStatus.BAD_REQUEST);
    }
}
