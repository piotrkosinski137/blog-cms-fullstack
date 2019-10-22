package com.blogen.auth.controller;

import com.auth0.jwt.JWT;
import com.blogen.auth.jwt.JwtProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.Objects;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@RestController
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;
    private String role;

    public AuthenticationRestController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {

        if(!authenticationSucceed(authenticationRequest.getUsername(), authenticationRequest.getPassword())) {
            throw new EntityNotFoundException("Wrong email or password");
        }

        final String token = JWT.create()
            .withSubject(authenticationRequest.getUsername())
            .withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
            .sign(HMAC512(JwtProperties.SECRET.getBytes()));

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token, authenticationRequest.getUsername(), role));
    }

    private boolean authenticationSucceed(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            role = authenticate.getAuthorities().stream().findFirst().get().toString();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
