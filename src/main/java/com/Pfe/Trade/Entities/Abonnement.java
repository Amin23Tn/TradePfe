package com.Pfe.Trade.Entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Abonnement")
public class Abonnement {
    @Id
    private String id ;
    @Field("startDate")
    private Date startDate =new Date();
    LocalDate date = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @Field("endDate")
    private Date endDate;
    @Field("type")
    private Etype type;

}
