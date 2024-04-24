package com.application.WinnersAcademy.controllers;

import com.application.WinnersAcademy.entities.Promotion;
import com.application.WinnersAcademy.services.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/promo")
    public ResponseEntity<Promotion> getPromo() {
        return ResponseEntity.ok(promotionService.getPromotionActive());
    }

    @PostMapping("/create")
    public ResponseEntity<Promotion> addPromo(@RequestBody Promotion promotion) {
        return ResponseEntity.ok(promotionService.addPromotion(promotion));
    }
}
