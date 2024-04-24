package com.application.WinnersAcademy.repository;

import com.application.WinnersAcademy.entities.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
    Promotion findByActif(Boolean actif);
}
