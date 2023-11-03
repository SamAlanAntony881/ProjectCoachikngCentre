package com.example.practice.ProjectCoachingCentre.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler()
    public ResponseEntity<Object> errorResponse(ExceptionRequest exceptionRequest){
        Exceptions exceptions = new Exceptions(
                exceptionRequest.getCode(),exceptionRequest.getMessage()
        );return new ResponseEntity<Object>(exceptions, HttpStatus.BAD_REQUEST);

    }
}

