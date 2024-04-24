package com.application.WinnersAcademy.controllers;

import com.application.WinnersAcademy.entities.Academiciens;
import com.application.WinnersAcademy.entities.Coordo;
import com.application.WinnersAcademy.services.CoordoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coordo")
public class CoodoController {

    @Autowired
    private CoordoService coordoService;

    @PostMapping("/nouveau")
    public ResponseEntity<Coordo> add(@RequestBody Coordo coordo) {
        return ResponseEntity.ok(coordoService.add(coordo));
    }
}
