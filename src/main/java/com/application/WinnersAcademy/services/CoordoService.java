package com.application.WinnersAcademy.services;

import com.application.WinnersAcademy.entities.Coordo;
import com.application.WinnersAcademy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordoService {

    @Autowired
    private UsersRepository usersRepository;

    public Coordo add(Coordo coordo) {
        return usersRepository.save(coordo);
    }
}
