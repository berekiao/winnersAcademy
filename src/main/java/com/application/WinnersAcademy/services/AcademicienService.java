package com.application.WinnersAcademy.services;

import com.application.WinnersAcademy.entities.Academiciens;
import com.application.WinnersAcademy.repository.PromotionRepository;
import com.application.WinnersAcademy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AcademicienService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PromotionRepository promotionRepository;

    public Academiciens add(Academiciens academiciens) {
        academiciens.setPromotion(promotionRepository.findByActif(true));
        return usersRepository.save(academiciens);
    }
}
