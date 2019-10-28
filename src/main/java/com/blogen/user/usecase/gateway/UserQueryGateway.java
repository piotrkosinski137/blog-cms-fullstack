package com.blogen.user.usecase.gateway;

import com.blogen.auth.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface UserQueryGateway {
    Optional<User> findByEmail(String email);
    Page<User> findPage(PageRequest pageRequest);
}
