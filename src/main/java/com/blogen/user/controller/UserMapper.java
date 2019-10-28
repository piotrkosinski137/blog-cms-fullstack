package com.blogen.user.controller;

import com.blogen.auth.Role;
import com.blogen.auth.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class UserMapper {

    UserMapper() {

    }

    UserDTO toDTO(User user) {
        return null;
    }

    User toEntity(UserDTO userDTO) {
        return User.create()
                .withEmail(userDTO.getCredentialsEmail())
                .withPassword(verifyPassword(userDTO.getCredentialsPassword(), userDTO.getConfirmPassword()))
                .andRole(verifyRole(userDTO.getRole()));
    }

    private Role verifyRole(String role) {
        return Arrays.asList(Role.values()).stream()
                .filter((Role r) -> r.name().equals(role))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Invalid role"));
    }

    private String verifyPassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new RuntimeException("Password and confirm password doesn't match");
        }
        return password;
    }
}
