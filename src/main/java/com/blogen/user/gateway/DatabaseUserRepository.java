package com.blogen.user.gateway;

import com.blogen.auth.User;
import com.blogen.auth.UserRepository;
import com.blogen.user.usecase.gateway.UserCommandGateway;
import com.blogen.user.usecase.gateway.UserQueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseUserRepository implements UserCommandGateway, UserQueryGateway {

    private final UserRepository userRepository;

    public DatabaseUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByCredentialsEmail(email);
    }

    @Override
    public Page<User> findPage(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }
}
