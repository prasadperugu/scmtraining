package com.prasad.scm.springapplication.payload.response;

public class MessageResponse {
    private String message;

    /**
     * Constructs a MessageResponse object with the provided message.
     *
     * @param message The response message
     */
    public MessageResponse(String message) {
        this.message = message;
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
}
