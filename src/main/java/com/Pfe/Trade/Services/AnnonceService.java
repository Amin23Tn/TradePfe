package com.Pfe.Trade.Services;

import com.Pfe.Trade.Entities.Annonce;
import com.Pfe.Trade.Repositories.AnnonceRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnnonceService {
    @Autowired
private AnnonceRepository annonceRepository;

    public Annonce saveAnnonce (Annonce annonce){
      return annonceRepository.save(annonce);
    }

    public Annonce UpdateAnnonce (Annonce annonce , String id){
    Annonce a = annonceRepository.findById(id).orElse(null);
    a.setType(annonce.getType());
    a.setStatus(annonce.getStatus());
    a.setContext(annonce.getContext());
    a.setDescription(annonce.getDescription());
    a.setDatePub(annonce.getDatePub());
    a.setDateExp(annonce.getDateExp());;
    a.setDateMission(annonce.getDateMission());
    a.setDureeMission(annonce.getDureeMission());
    a.setNiveau(annonce.getNiveau());
    a.setSecteurActivite(annonce.getSecteurActivite());
    return annonceRepository.save(a);
    }

    private static final Logger l = LogManager.getLogger(AnnonceService.class);
    public List<Annonce> retrieveAllAnnonces(Pageable pageable) {
        return StreamSupport.stream(annonceRepository.findAll(pageable).spliterator(), false).collect(Collectors.toList());
    }

    public Annonce getAnnonceById(String id) {
        return annonceRepository.findById(id).orElse(null);
    }

    public String DeleteAnnonce (String id) {
       annonceRepository.deleteById(id);
        return "user Removed !!" + id ;
    }
    public List<Annonce> searchAnnonceByDesc(String description) {

        List<Annonce> annonces = annonceRepository.getAnnonceByDescriptionLike(description);
        return annonces;
    }

    public List<Annonce> searchAnnonceByDate(LocalDate datePub) {

        List<Annonce> annonces = annonceRepository.getAnnonceByDatePubLike(datePub);
        return annonces;
    }




}
