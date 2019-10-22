package com.blogen.auth.controller;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1250166508152483573L;

    private final String token;
    private final String username;
    private final String role;

    public JwtAuthenticationResponse(String token, String username, String role) {
        this.token = token;
        this.role = role;
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }
    public String getToken() {
        return token;
    }
}
