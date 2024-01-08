package com.concessionary.domain.model.error;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ErrorResponse
{
    private LocalDateTime timeStamp;
    private String message;
    private List<String> fieldErrors = new ArrayList<>();

    public ErrorResponse() {}

    public ErrorResponse(LocalDateTime timeStamp, String message) {
        this.timeStamp = timeStamp;
        this.message = message;
    }

    public ErrorResponse(LocalDateTime timeStamp, String message, List<String> fieldErrors) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.fieldErrors = fieldErrors;
    }


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
