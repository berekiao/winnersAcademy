package com.application.WinnersAcademy.services;

import com.application.WinnersAcademy.entities.Academiciens;
import com.application.WinnersAcademy.entities.Coordo;
import com.application.WinnersAcademy.repository.AcademicienRepository;
import com.application.WinnersAcademy.repository.CoordoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AffectationService {

    @Autowired
    private CoordoRepository coordoRepository;
    @Autowired
    private AcademicienRepository academicienRepository;

    public void affecterAcademiciensACordo(Long coordoId, List<Long> academicienIds) {

        Coordo coordo = coordoRepository.findById(coordoId)
                .orElseThrow(() -> new EntityNotFoundException("Coordo non trouvé avec l'ID : " + coordoId));

        List<Academiciens> academiciens = academicienRepository.findAllById(academicienIds);

        for (Academiciens academicien : academiciens) {
            if (academicien.getCoordo() != null) {
                throw new IllegalArgumentException("Academicien avec l'ID " + academicien.getId() + " est déjà affecté à un coordo.");
            }
            academicien.setCoordo(coordo);
        }
        academicienRepository.saveAll(academiciens);
    }

}
