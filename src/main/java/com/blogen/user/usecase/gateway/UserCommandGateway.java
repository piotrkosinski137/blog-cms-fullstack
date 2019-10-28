package com.blogen.user.usecase.gateway;

import com.blogen.auth.User;

public interface UserCommandGateway {
    void save(User user);
}
