package com.application.WinnersAcademy.repository;

import com.application.WinnersAcademy.entities.Academiciens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcademicienRepository extends JpaRepository<Academiciens, Long> {


}
