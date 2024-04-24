package com.application.WinnersAcademy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom, prenoms, profession, paysOrigine, villeVillageResidence, personneAContacter, situationMatrimoniale, egliseLocal;
    @Column(unique = true, nullable = false)
    private String email, contact;
    private String password;
    private String profile;
    @ManyToOne
    private Role role;
    private boolean activated, verified;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Version
    private Timestamp version;
    @PrePersist
    public void initDateCreation() {
        this.dateCreation = new Date();
    }

}
