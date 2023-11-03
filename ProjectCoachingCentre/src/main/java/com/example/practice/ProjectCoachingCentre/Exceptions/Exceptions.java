package com.example.practice.ProjectCoachingCentre.Exceptions;

public class Exceptions {
    Integer errorCode;
    String errorMessage;

    public Exceptions(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
