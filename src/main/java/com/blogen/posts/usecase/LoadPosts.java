package com.blogen.posts.usecase;

import com.blogen.posts.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface LoadPosts {
    Post loadById(Integer id);

    Page<Post> loadPage(PageRequest pageRequest);
}
