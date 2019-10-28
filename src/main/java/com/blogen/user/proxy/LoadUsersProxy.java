package com.blogen.user.proxy;


import com.blogen.auth.User;
import com.blogen.user.usecase.LoadUsers;
import com.blogen.user.usecase.gateway.UserQueryGateway;
import com.blogen.user.usecase.impl.LoadUsersUsecase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LoadUsersProxy implements LoadUsers {

    private final LoadUsers loadUsers;

    public LoadUsersProxy(UserQueryGateway userQueryGateway) {
        this.loadUsers = new LoadUsersUsecase(userQueryGateway);
    }

    @Override
    public Page<User> loadPage(PageRequest page) {
        return loadUsers.loadPage(page);
    }
}
