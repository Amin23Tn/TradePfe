package com.Pfe.Trade.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "CV")
public class CV {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String profil;
    private String DossComp;
    private String ExpProf;
    private String diplome;
    private String formation;
    private String langue;
}
