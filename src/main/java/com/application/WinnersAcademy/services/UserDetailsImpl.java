package com.application.WinnersAcademy.services;

import com.application.WinnersAcademy.entities.Role;
import com.application.WinnersAcademy.entities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private final Long id;
    private final String email;
    private final String nom;
    private final String prenoms;
    private final Role role;
    private final String password;
    private final GrantedAuthority authority;

    public UserDetailsImpl(Long id, String email, String nom, String prenoms, Role role, String password, GrantedAuthority authority) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.prenoms = prenoms;
        this.role = role;
        this.password = password;
        this.authority = authority;
    }

    public static UserDetailsImpl build(Users users) {
        GrantedAuthority authorities = new SimpleGrantedAuthority("ROLE_" + users.getRole().toString());

        return new UserDetailsImpl(
                users.getId(),
                users.getEmail(),
                users.getNom(),
                users.getPrenoms(),
                users.getRole(),
                users.getPassword(),
                authorities
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(authority);
        return authorities;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public GrantedAuthority getAuthority() {
        return authority;
    }

}
