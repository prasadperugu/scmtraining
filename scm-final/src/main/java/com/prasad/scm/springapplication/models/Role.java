package com.prasad.scm.springapplication.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
public class Role {
    @Id
    private String id; // Unique identifier for the role

    private ERole name; // Name of the role

    List<String> url; // List of URLs associated with the role

    /**
     * Default constructor.
     */
    public Role() {

    }

    /**
     * Get the list of URLs associated with the role.
     *
     * @return The list of URLs.
     */
    public List<String> getUrl() {
        return url;
    }

    /**
     * Set the list of URLs associated with the role.
     *
     * @param url The list of URLs.
     */
    public void setUrl(List<String> url) {
        this.url = url;
    }

    /**
     * Create a new Role instance with the specified name.
     *
     * @param name The name of the role.
     */
    public Role(ERole name) {
        this.name = name;
    }

    /**
     * Get the ID of the role.
     *
     * @return The role ID.
     */
    public String getId() {
        return id;
    }

    /**
     * Set the ID of the role.
     *
     * @param id The role ID.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the name of the role.
     *
     * @return The role name.
     */
    public ERole getName() {
        return name;
    }

    /**
     * Set the name of the role.
     *
     * @param name The role name.
     */
    public void setName(ERole name) {
        this.name = name;
    }
}
