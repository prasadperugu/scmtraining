package com.prasad.scm.springapplication.payload.request;

import java.util.Set;
import javax.validation.constraints.Email;

public class SignupRequest {

    private String username;  // Stores the username provided by the user during signup

    @Email
    private String email;  // Stores the email address provided by the user during signup

    private Set<String> roles;  // Stores the roles assigned to the user during signup

    private String password;  // Stores the password provided by the user during signup

    /**
     * Retrieves the username provided by the user during signup.
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username provided by the user during signup.
     *
     * @param username The username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the email address provided by the user during signup.
     *
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address provided by the user during signup.
     *
     * @param email The email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retrieves the roles assigned to the user during signup.
     *
     * @return The set of roles
     */
    public Set<String> getRoles() {
        return this.roles;
    }

    /**
     * Sets the roles assigned to the user during signup.
     *
     * @param roles The set of roles to set
     */
    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    /**
     * Retrieves the password provided by the user during signup.
     *
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password provided by the user during signup.
     *
     * @param password The password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
