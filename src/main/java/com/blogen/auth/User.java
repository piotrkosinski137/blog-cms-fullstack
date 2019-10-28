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

    @Transient
    private String confirmPassword;

    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    User() {
        this.id = EntityId.create();
    }

    public static UserBuilderInterfaces.UserEmailInterface create() {
        return UserBuilder.getInstance();
    }

    public EntityId getId() {
        return id;
    }

    public String getCredentialsEmail() {
        return credentialsEmail;
    }

    public String getCredentialsPassword() {
        return credentialsPassword;
    }

    public Role getRole() {
        return role;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    void setCredentialsEmail(String credentialsEmail) {
        this.credentialsEmail = credentialsEmail;
    }

    void setCredentialsPassword(String credentialsPassword) {
        this.credentialsPassword = credentialsPassword;
    }

    void setRole(Role role) {
        this.role = role;
    }
}
