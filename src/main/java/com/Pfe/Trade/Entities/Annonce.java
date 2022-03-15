package com.Pfe.Trade.Entities;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Annonce")
public class Annonce {
    @Id
    private String id ;
    @Field("type")
    @NotEmpty
    private String type ;
    @Field("status")
    @NotEmpty
    private String status;
    @Field("context")
    @NotEmpty
    private String context;

    @Field("description")
    @NotEmpty
    private String description;
    @Field("datePub")
    private Date DatePub = new Date();
    LocalDate date = DatePub.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    @Field("dateExp")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "add Date")
    private Date DateExp;
    @Field("dateMission")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotNull(message = "add Date")
    private Date DateMission;
    @Field("dureeMission")
    @NotEmpty
    private String DureeMission;
    @Field("niveau")
    @NotEmpty
    private String niveau;
    @Field("secteurActivite")
    @NotEmpty
    private String SecteurActivite;
}
