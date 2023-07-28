package com.prasad.scm.springapplication.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginRequest {
//    @NotBlank
    @Email
    private String email;

    /**
     * Retrieves the user's email.
     *
     * @return The user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     *
     * @param email The user's email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank
    private String username;

    /**
     * Retrieves the user's username.
     *
     * @return The user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username.
     *
     * @param username The user's username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    /**
     * Retrieves the user's password.
     *
     * @return The user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password The user's password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
