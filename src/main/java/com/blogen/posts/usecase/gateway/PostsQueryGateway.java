package com.blogen.posts.usecase.gateway;

import com.blogen.posts.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface PostsQueryGateway {
    Optional<Post> loadById(Integer id);
    Page<Post> loadPage(PageRequest pageRequest);
}
