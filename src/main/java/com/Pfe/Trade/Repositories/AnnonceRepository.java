package com.Pfe.Trade.Repositories;

import com.Pfe.Trade.Entities.Annonce;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface AnnonceRepository extends MongoRepository <Annonce,String> {
    Page<Annonce>findAll(Pageable pageable);
   List<Annonce> getAnnonceByDescriptionLike(String description);
   List<Annonce> getAnnonceByDatePubLike(LocalDate datePub);



}
