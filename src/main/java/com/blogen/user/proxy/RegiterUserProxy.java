package com.blogen.user.proxy;

import com.blogen.auth.User;
import com.blogen.user.usecase.RegisterUser;
import com.blogen.user.usecase.gateway.UserCommandGateway;
import com.blogen.user.usecase.gateway.UserQueryGateway;
import com.blogen.user.usecase.impl.RegisterUserUsecase;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegiterUserProxy implements RegisterUser {

    private final RegisterUser registerUser;

    public RegiterUserProxy(UserCommandGateway userCommandGateway, UserQueryGateway userQueryGateway, PasswordEncoder encoder) {
        registerUser = new RegisterUserUsecase(userCommandGateway, userQueryGateway, encoder);
    }

    @Override
    public void register(User user) {
        registerUser.register(user);
    }
}
