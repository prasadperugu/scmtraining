package com.prasad.scm.springapplication.repository;

import java.util.Optional;

import com.prasad.scm.springapplication.models.ERole;
import com.prasad.scm.springapplication.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    /**
     * Retrieves a role by its name.
     *
     * @param name The name of the role
     * @return An optional containing the role with the specified name, or an empty optional if not found
     */
    Optional<Role> findByName(ERole name);

    /**
     * Retrieves a role by its URL.
     *
     * @param url The URL of the role
     * @return An optional containing the role with the specified URL, or an empty optional if not found
     */
    Optional<Role> findByUrl(ERole url);
}
