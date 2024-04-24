package com.application.WinnersAcademy.controllers;

import com.application.WinnersAcademy.services.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/affectation")
public class AffectationController {

    @Autowired
    private AffectationService affectationService;

    @PostMapping("/assignation/{coordoId}")
    public ResponseEntity<Void> affecterAcademiciensACordo(@PathVariable Long coordoId, @RequestBody List<Long> academicienIds) {
        affectationService.affecterAcademiciensACordo(coordoId, academicienIds);
        return ResponseEntity.ok().build();
    }
}
