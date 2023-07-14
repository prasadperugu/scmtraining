package com.prasad.scm.springapplication.repository;

import java.util.Optional;

import com.prasad.scm.springapplication.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * Finds a user by their username.
     *
     * @param username User's username
     * @return User object if found, null otherwise
     */
    User findByUsername(String username);

    /**
     * Finds a user by their email.
     *
     * @param email User's email
     * @return User object wrapped in an Optional if found, empty Optional otherwise
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds a user by their token.
     *
     * @param token User's token
     * @return User object if found, null otherwise
     */
    User findByToken(String token);

    /**
     * Checks if a user with the given username exists.
     *
     * @param username User's username
     * @return true if a user with the given username exists, false otherwise
     */
    Boolean existsByUsername(String username);

    /**
     * Checks if a user with the given email exists.
     *
     * @param email User's email
     * @return true if a user with the given email exists, false otherwise
     */
    Boolean existsByEmail(String email);
}
