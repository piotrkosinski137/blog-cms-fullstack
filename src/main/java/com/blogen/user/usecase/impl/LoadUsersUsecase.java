package com.blogen.user.usecase.impl;

import com.blogen.auth.User;
import com.blogen.user.usecase.LoadUsers;
import com.blogen.user.usecase.gateway.UserQueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class LoadUsersUsecase implements LoadUsers {

    private final UserQueryGateway userQueryGateway;

    public LoadUsersUsecase(UserQueryGateway userQueryGateway) {
        this.userQueryGateway = userQueryGateway;
    }

    @Override
    public Page<User> loadPage(PageRequest page) {
        return userQueryGateway.findPage(page);
    }
}
