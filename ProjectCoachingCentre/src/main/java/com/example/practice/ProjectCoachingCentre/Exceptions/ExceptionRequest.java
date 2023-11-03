package com.example.practice.ProjectCoachingCentre.Exceptions;

public class ExceptionRequest extends Exception {
    Integer code;

    public Integer getCode() {
        return code;
    }

    public ExceptionRequest( Integer code,String message) {
        super(message);
        this.code=code;
    }
}
