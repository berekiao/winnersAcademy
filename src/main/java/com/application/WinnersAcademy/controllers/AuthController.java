package com.application.WinnersAcademy.controllers;

import com.application.WinnersAcademy.commons.AuthRequest;
import com.application.WinnersAcademy.commons.AuthResponse;
import com.application.WinnersAcademy.jwt.JwtUtils;
import com.application.WinnersAcademy.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest authenticationRequest, HttpServletRequest request) throws Exception {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        AuthResponse authResponse = new AuthResponse(jwt, userDetails.getId(), userDetails.getEmail(), userDetails.getRole(), userDetails.getNom(), userDetails.getPrenoms());

        return ResponseEntity.ok(authResponse);
    }
}
