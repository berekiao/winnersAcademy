package com.application.WinnersAcademy.services;

import com.application.WinnersAcademy.entities.Promotion;
import com.application.WinnersAcademy.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public Promotion getPromotionActive() {
        return promotionRepository.findByActif(true);
    }

    public Promotion addPromotion(Promotion promotion) {
        Promotion promotionActif = promotionRepository.findByActif(true);
        if (promotionActif != null) {
            throw new IllegalStateException("Il y a déjà une promotion active");
        } else {
            return promotionRepository.save(promotion);
        }
    }
}
