package com.prasad.scm.springapplication.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id; // Unique identifier for the user

    @NotBlank
    private String username; // Username of the user

    @NotBlank
    @Email
    private String email; // Email address of the user

    @NotBlank
    private String password; // User's password

    private String token; // Token associated with the user

    @DBRef
    private Set<Role> roles = new HashSet<>(); // Set of roles assigned to the user

    private LocalDateTime tokenCreationDate; // Date and time when the token was created

    public User() {
    }

    /**
     * Create a new User instance with the specified username, email, and password.
     *
     * @param username The username.
     * @param email    The email address.
     * @param password The password.
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Get the ID of the user.
     *
     * @return The user ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of the user.
     *
     * @param id The user ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the username of the user.
     *
     * @return The username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username of the user.
     *
     * @param username The username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the email address of the user.
     *
     * @return The email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email address of the user.
     *
     * @param email The email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the password of the user.
     *
     * @return The password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     *
     * @param password The password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the token associated with the user.
     *
     * @return The token.
     */
    public String getToken() {
        return token;
    }

    /**
     * Set the token associated with the user.
     *
     * @param token The token.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Get the set of roles assigned to the user.
     *
     * @return The set of roles.
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Set the set of roles assigned to the user.
     *
     * @param roles The set of roles.
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", roles="
                + roles + ", getId()=" + getId() + ", getUsername()=" + getUsername() + ", getEmail()=" + getEmail()
                + ", getPassword()=" + getPassword() + ", getRoles()=" + getRoles() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}
