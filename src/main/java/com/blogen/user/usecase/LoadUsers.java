package com.blogen.user.usecase;

import com.blogen.auth.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface LoadUsers {
    Page<User> loadPage(PageRequest of);
}
