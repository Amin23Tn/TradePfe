package com.Pfe.Trade.Repositories;

import com.Pfe.Trade.Entities.Abonnement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AbonnementRepository extends MongoRepository<Abonnement,String> {
    Page<Abonnement> findAll(Pageable pageable);
}
