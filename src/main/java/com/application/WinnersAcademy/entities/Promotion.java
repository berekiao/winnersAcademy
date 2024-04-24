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
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String intitule;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    private Boolean actif;
    private Boolean inscription;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Version
    private Timestamp version;

    @PrePersist
    public void initDateCreation() {
        dateCreation = new Date();
    }

}
