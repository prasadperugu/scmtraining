package com.prasad.scm.springapplication.payload.response;

import org.springframework.http.HttpStatus;

public class ForgotPasswordResponse {
    private String message;
    private HttpStatus status;

    public ForgotPasswordResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
