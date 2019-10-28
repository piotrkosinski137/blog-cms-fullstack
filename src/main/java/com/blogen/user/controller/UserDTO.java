package com.blogen.user.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

    @JsonProperty(value = "id")
    private String idValue;

    @JsonProperty(value = "role")
    private String role;

    @JsonProperty(value = "password")
    private String credentialsPassword;

    private String confirmPassword;

    @JsonProperty(value = "email")
    private String credentialsEmail;

    public UserDTO() {
    }

    public String getIdValue() {
        return idValue;
    }

    public void setIdValue(String idValue) {
        this.idValue = idValue;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCredentialsPassword() {
        return credentialsPassword;
    }

    public void setCredentialsPassword(String credentialsPassword) {
        this.credentialsPassword = credentialsPassword;
    }

    public String getCredentialsEmail() {
        return credentialsEmail;
    }

    public void setCredentialsEmail(String credentialsEmail) {
        this.credentialsEmail = credentialsEmail;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
