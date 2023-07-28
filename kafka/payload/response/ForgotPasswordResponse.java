package com.prasad.scm.springapplication.payload.response;

import org.springframework.http.HttpStatus;

public class ForgotPasswordResponse {
    private String message;
    private HttpStatus status;

    /**
     * Constructs a ForgotPasswordResponse object with the specified message and status.
     *
     * @param message The response message
     * @param status  The HTTP status code
     */
    public ForgotPasswordResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    /**
     * Retrieves the response message.
     *
     * @return The response message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the response message.
     *
     * @param message The response message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Retrieves the HTTP status code.
     *
     * @return The HTTP status code
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code.
     *
     * @param status The HTTP status code to set
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
