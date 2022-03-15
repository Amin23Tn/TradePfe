package com.Pfe.Trade.Controllers;

import com.Pfe.Trade.Entities.Abonnement;

import com.Pfe.Trade.Services.AbonnementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/abonnement")
public class AbonnemlentController {

    @Autowired
    AbonnementService abonnementService;

    @PostMapping("/")
    public Abonnement addAbb (@RequestBody Abonnement abonnement){
        return abonnementService.saveAbb(abonnement);
    }

    @GetMapping("/{id}")
    public Abonnement findAbbById(@PathVariable String id){
        return abonnementService.getAbbById(id);
    }

    @GetMapping("/")
    public List<Abonnement> findAllAbb(Pageable pageable){
        return  abonnementService.retrieveAllAbb(pageable);
    }
    @GetMapping("/{endDate}/{date}")
    public boolean Compare(@PathVariable Date endDate, @PathVariable LocalDate date){
        return abonnementService.Campare(endDate, date);
    }

}
