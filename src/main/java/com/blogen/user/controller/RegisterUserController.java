package com.blogen.user.controller;

import com.blogen.user.usecase.RegisterUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class RegisterUserController {

    private final RegisterUser registerUser;
    private final UserMapper mapper = new UserMapper();

    public RegisterUserController(RegisterUser registerUser) {
        this.registerUser = registerUser;
    }

    @PostMapping("/register")
    public void addUser(@RequestBody UserDTO userDTO) {
        registerUser.register(mapper.toEntity(userDTO));
    }
}
