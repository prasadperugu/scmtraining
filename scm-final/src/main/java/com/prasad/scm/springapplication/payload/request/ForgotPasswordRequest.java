package com.prasad.scm.springapplication.payload.request;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "forgot_password_requests")
public class ForgotPasswordRequest {

    @Id
    private Long id; // Unique identifier for the request

    private String username; // Username of the user requesting the password reset
    private String email; // Email address of the user
    private String password; // New password to be set
    private String token; // Token generated for password reset verification
    private LocalDateTime tokenCreationDate; // Date and time when the token was created

    /**
     * Get the ID of the forgot password request.
     *
     * @return The ID of the request.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the forgot password request.
     *
     * @param id The ID of the request.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the username associated with the forgot password request.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username associated with the forgot password request.
     *
     * @param username The username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the email address associated with the forgot password request.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address associated with the forgot password request.
     *
     * @param email The email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the new password to be set.
     *
     * @return The new password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the new password to be set.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the token generated for password reset verification.
     *
     * @return The verification token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Set the token generated for password reset verification.
     *
     * @param token The verification token.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Get the date and time when the token was created.
     *
     * @return The token creation date.
     */
    public LocalDateTime getTokenCreationDate() {
        return tokenCreationDate;
    }

    /**
     * Set the date and time when the token was created.
     *
     * @param tokenCreationDate The token creation date.
     */
    public void setTokenCreationDate(LocalDateTime tokenCreationDate) {
        this.tokenCreationDate = tokenCreationDate;
    }
}
