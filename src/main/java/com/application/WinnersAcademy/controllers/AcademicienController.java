package com.application.WinnersAcademy.controllers;

import com.application.WinnersAcademy.entities.Academiciens;
import com.application.WinnersAcademy.services.AcademicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/academicien")
public class AcademicienController {

    @Autowired
    private AcademicienService academicienService;
    @PostMapping("/nouveau")
    public ResponseEntity<Academiciens> add(@RequestBody Academiciens academiciens) {
        return ResponseEntity.ok(academicienService.add(academiciens));
    }
}
