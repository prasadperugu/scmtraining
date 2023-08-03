package com.prasad.scm.springapplication.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String email;
    private List<String> roles;

    /**
     * Constructs a JwtResponse object with the provided access token, user details, and roles.
     *
     * @param accessToken The JWT access token
     * @param id          The user's ID
     * @param username    The user's username
     * @param email       The user's email
     * @param roles       The user's roles
     */
    public JwtResponse(String accessToken, String id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    /**
     * Retrieves the access token.
     *
     * @return The access token
     */
    public String getAccessToken() {
        return token;
    }

    /**
     * Sets the access token.
     *
     * @param accessToken The access token to set
     */
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    /**
     * Retrieves the token type.
     *
     * @return The token type
     */
    public String getTokenType() {
        return type;
    }

    /**
     * Sets the token type.
     *
     * @param tokenType The token type to set
     */
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    /**
     * Retrieves the user's ID.
     *
     * @return The user's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the user's ID.
     *
     * @param id The user's ID to set
     */
    public void setId(String id) {
        this.id = id;
    }

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

    /**
     * Retrieves the user's roles.
     *
     * @return The user's roles
     */
    public List<String> getRoles() {
        return roles;
    }
}
