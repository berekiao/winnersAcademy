package com.application.WinnersAcademy.commons;

import com.application.WinnersAcademy.entities.Role;

public class AuthResponse {
    private String token;
    private Long id;
    private String email;
    private Role role;
    private String nom;
    private String prenoms;

    public AuthResponse(String token, Long id, String email, Role role, String nom, String prenoms) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.role = role;
        this.nom = nom;
        this.prenoms = prenoms;
    }

    public String getToken() {
        return token;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenoms() {
        return prenoms;
    }
}
