package com.luv2code.demo.rest;

public class StudentErrorResponse {
    private int status;
    private String errorMessage;
    private Long timestamp;

    public StudentErrorResponse() {

    }
    public StudentErrorResponse(int status, String errorMessage, Long timestamp) {
        this.status = status;
        this.errorMessage = errorMessage;
        this.timestamp = timestamp;
    }
    public int getStatus() {
        return status;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public Long getTimestamp() {
        return timestamp;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
