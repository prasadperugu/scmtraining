package com.prasad.scm.springapplication.repository;

import com.prasad.scm.springapplication.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);

    Optional<User> findByEmail(String email);

    User findByToken(String token);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
