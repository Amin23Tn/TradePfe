package com.Pfe.Trade.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "roles")
public class Role {
    @Id
    private String id;
    private ERole name;

    public ERole getName() {
        return name;
    }
    public void setName(ERole name) {
        this.name = name;
    }
}
