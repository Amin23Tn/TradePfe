package com.Pfe.Trade.Services;


import com.Pfe.Trade.Entities.Abonnement;
import com.Pfe.Trade.Repositories.AbonnementRepository;
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
public class AbonnementService {
    @Autowired
    private AbonnementRepository abonnementRepository;

    public Abonnement saveAbb(Abonnement abonnement){
        return abonnementRepository.save(abonnement);
    }

    public Abonnement getAbbById(String id){
        return abonnementRepository.findById(id).orElse(null);
    }

    private static final Logger l = LogManager.getLogger(AbonnementService.class);
    public List<Abonnement> retrieveAllAbb(Pageable pageable) {
        return StreamSupport.stream(abonnementRepository.findAll(pageable).spliterator(), false).collect(Collectors.toList());
    }

    public boolean Campare(Date endDate , LocalDate localDate) {
        if (endDate.equals(localDate))
            return true;
        else
            return false;
    }

}
