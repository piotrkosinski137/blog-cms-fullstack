package com.blogen.user.controller;

import com.blogen.auth.User;
import com.blogen.commons.PageDTO;
import com.blogen.commons.Pages;
import com.blogen.posts.controller.Mapper;
import com.blogen.user.usecase.LoadUsers;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class LoadUsersController {

    private final LoadUsers loadUsers;
    private final ModelMapper mapper = Mapper.initialize();

    public LoadUsersController(LoadUsers loadUsers) {
        this.loadUsers = loadUsers;
    }

    @GetMapping
    public PageDTO<UserDTO> loadPage(@RequestParam int page, @RequestParam int size) {
        Page<User> users = loadUsers.loadPage(PageRequest.of(page, size));
        return Pages.mapContent(users, user -> mapper.map(user, UserDTO.class));
    }
}
