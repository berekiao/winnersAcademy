package com.application.WinnersAcademy.repository;

import com.application.WinnersAcademy.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
