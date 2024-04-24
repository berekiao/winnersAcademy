package com.application.WinnersAcademy.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Academiciens extends Users{

    private boolean baptemeEau, baptemeEsprit;
    @Lob
    private String AttenteAcademy, AttenteCoordo;
    @ManyToOne
    private Promotion promotion;
    @ManyToOne
    private Coordo coordo;

}
