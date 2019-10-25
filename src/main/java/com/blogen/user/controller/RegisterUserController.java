package com.blogen.user.controller;

import com.blogen.auth.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class RegisterUserController {

    private final UserMapper mapper = new UserMapper();
    
    @PostMapping("/register")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        mapper.toEntity(userDTO);
        return null;
    }
}
