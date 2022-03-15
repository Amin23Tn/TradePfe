package com.Pfe.Trade.Repositories;

import com.Pfe.Trade.Entities.ERole;
import com.Pfe.Trade.Entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository <Role,String> {
    Optional<Role> findByName(ERole name);
}
