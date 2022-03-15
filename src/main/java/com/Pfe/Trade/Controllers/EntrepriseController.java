package com.Pfe.Trade.Controllers;

import com.Pfe.Trade.Entities.Entreprise;
import com.Pfe.Trade.Services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entreprise")
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;

    @PostMapping("/")
    public Entreprise saveEntreprise(@Valid @RequestBody Entreprise entreprise) {
        return entrepriseService.saveEntreprise(entreprise);
    }

    @PutMapping("/")
    public Entreprise EditEntreprise(@Valid @RequestBody Entreprise entreprise, @PathVariable("id") String id) {
        return entrepriseService.UpdateEntreprise(entreprise, id);
    }

    @GetMapping("/{id}")
    public Optional<Entreprise> getEntrepriseById(@PathVariable("id") String id) {
        return entrepriseService.getEntrepriseById(id);
    }

    @GetMapping("/")
    public List<Entreprise> getAllEntreprise(Pageable pageable) {
        return entrepriseService.getAllEntreprise(pageable);
    }

    @DeleteMapping("/{id}")
    public String DeleteEntreprise(@PathVariable("id") String id) {
        return entrepriseService.DeleteById(id);
    }
}
