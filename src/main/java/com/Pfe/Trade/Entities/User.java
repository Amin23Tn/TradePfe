package com.Pfe.Trade.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User {
        @Id
        private String id;
        private String username;
        private String lastname;
        private String email;
       // private String login;
        private String password;
        private String region;
        private String departement;
        private int codepostal;
        private String adresse;
        private Integer telephone;
       // private String type;

        private Set<Role> roles = new HashSet<>();

        public User(String username, String email, String password) {
                this.username = username;
                this.email= email;
                this.password=password;
        }

}
