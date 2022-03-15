package com.Pfe.Trade.Repositories;

import com.Pfe.Trade.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository <User,String> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String Email);

    User getUsersById(String id);
}
