package com.blogen.auth;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @EmbeddedId
    private EntityId id;

    @Column(name = "EMAIL")
    private String credentialsEmail;

    @Column(name = "PASSWORD")
    private String credentialsPassword;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    private User() {
    }

    public User(EntityId id, String credentialsEmail, String credentialsPassword, Role role) {
        this.id = id;
        this.credentialsEmail = credentialsEmail;
        this.credentialsPassword = credentialsPassword;
        this.role = role;
    }

    public EntityId getId() {
        return id;
    }

    public void setId(EntityId id) {
        this.id = id;
    }

    public String getCredentialsEmail() {
        return credentialsEmail;
    }

    public void setCredentialsEmail(String credentialsEmail) {
        this.credentialsEmail = credentialsEmail;
    }

    public String getCredentialsPassword() {
        return credentialsPassword;
    }

    public void setCredentialsPassword(String credentialsPassword) {
        this.credentialsPassword = credentialsPassword;
    }

    public Role getRole() {
        return role;
    }
}
