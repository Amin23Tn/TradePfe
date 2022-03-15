package com.Pfe.Trade.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "entreprise")
public class Entreprise {

    @Id
    private String id;
    @Field("nom")
    @NotEmpty
    @Size(min=2,message = "name should have at least 2 characters")
    private String nom;

    @Field("SecteurActivite")
    @NotEmpty
    private String SecteurActivite;
    @Field("type")
    @NotEmpty
    private String type;

    @Field("DateFoundation")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "add Date")
    private Date DateFondation ;
    @Field("taille")
    @NotNull
    private Long taille;
    @Field("region")
    @NotEmpty
    private String region;
    @Field("departement")
    @NotEmpty
    private String departement;
    @Field("CodePostal")
    @NotNull
    private int CodePostal;
    @Field("adresse")
    @NotEmpty
    private String adresse;

}
