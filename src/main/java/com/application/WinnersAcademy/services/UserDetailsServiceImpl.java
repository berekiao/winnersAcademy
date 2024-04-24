package com.application.WinnersAcademy.services;

import com.application.WinnersAcademy.entities.Users;
import com.application.WinnersAcademy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsersRepository usersRepository;

    @Autowired
    public UserDetailsServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            Users users = usersRepository.findByEmail(email);

            return UserDetailsImpl.build(users);
        } catch (Exception e) {
            return (UserDetails) new UsernameNotFoundException("User Not Found with email: " + email);
        }
    }
}
