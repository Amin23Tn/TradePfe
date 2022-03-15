package com.Pfe.Trade.Services;

import com.Pfe.Trade.Entities.Entreprise;
import com.Pfe.Trade.Repositories.EntrepriseRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EntrepriseService {
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    public Entreprise saveEntreprise(Entreprise entreprise){
        return entrepriseRepository.save(entreprise);
    }

    public Entreprise UpdateEntreprise (Entreprise entreprise , String id){
        Entreprise e = entrepriseRepository.findById(id).orElse(null);
        e.setNom(entreprise.getNom());
        e.setSecteurActivite(entreprise.getSecteurActivite());
        e.setType(entreprise.getType());
        e.setDateFondation(entreprise.getDateFondation());
        e.setTaille(entreprise.getTaille());
        e.setRegion(entreprise.getRegion());
        e.setDepartement(entreprise.getDepartement());
        e.setCodePostal(entreprise.getCodePostal());
        e.setAdresse(entreprise.getAdresse());
        return entrepriseRepository.save(e);
    }

    private static final Logger l = LogManager.getLogger(EntrepriseService.class);
    public List<Entreprise> getAllEntreprise(Pageable pageable){
        return (List<Entreprise>) StreamSupport.stream(entrepriseRepository.findAll(pageable).spliterator(), false).collect(Collectors.toList());
    }
    public Optional<Entreprise> getEntrepriseById(String id){
        return entrepriseRepository.findById(id);


    }
    public String DeleteById (String id){
        entrepriseRepository.deleteById(id);
        return "entreprise removed !" +id;
    }
}
