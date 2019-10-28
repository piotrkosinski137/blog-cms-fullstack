package com.blogen.user.usecase.impl;

import com.blogen.auth.User;
import com.blogen.user.usecase.RegisterUser;
import com.blogen.user.usecase.gateway.UserCommandGateway;
import com.blogen.user.usecase.gateway.UserQueryGateway;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class RegisterUserUsecase implements RegisterUser {

    private final UserCommandGateway userCommandGateway;
    private final UserQueryGateway userQueryGateway;
    private final PasswordEncoder encoder;

    public RegisterUserUsecase(UserCommandGateway userCommandGateway, UserQueryGateway userQueryGateway, PasswordEncoder encoder) {
        this.userCommandGateway = userCommandGateway;
        this.userQueryGateway = userQueryGateway;
        this.encoder = encoder;
    }

    @Override
    public void register(User user) {
        Optional<User> foundUser = userQueryGateway.findByEmail(user.getCredentialsEmail());

        if(foundUser.isPresent())
        {
            throw new RuntimeException("User with given id already exist in our database. Try again...");
        }

        userCommandGateway.save(user);
    }
}
