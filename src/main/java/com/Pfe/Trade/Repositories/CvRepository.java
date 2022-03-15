package com.Pfe.Trade.Repositories;

import com.Pfe.Trade.Entities.CV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CvRepository extends MongoRepository <CV,String> {
    Page <CV> findAll(Pageable pageable);
    List<CV> searchCVByFormationLike(String formation);

    CV findCVById(String id);

}
