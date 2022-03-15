package com.Pfe.Trade.Repositories;

import com.Pfe.Trade.Entities.Entreprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepriseRepository extends MongoRepository<Entreprise,String> {
    Page<Entreprise>findAll(Pageable pageable);

}
