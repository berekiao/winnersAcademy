package com.application.WinnersAcademy.services;

import com.application.WinnersAcademy.entities.Role;
import com.application.WinnersAcademy.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> getRole(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }


}
