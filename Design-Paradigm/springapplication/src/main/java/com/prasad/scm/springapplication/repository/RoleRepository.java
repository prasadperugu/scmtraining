package com.prasad.scm.springapplication.repository;

import java.util.Optional;

import com.prasad.scm.springapplication.models.ERole;
import com.prasad.scm.springapplication.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(ERole name);

    Optional<Role> findByUrl(ERole url);
}
