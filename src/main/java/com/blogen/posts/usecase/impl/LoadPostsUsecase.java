package com.blogen.posts.usecase.impl;

import com.blogen.posts.domain.Post;
import com.blogen.posts.usecase.LoadPosts;
import com.blogen.posts.usecase.gateway.PostsQueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class LoadPostsUsecase implements LoadPosts {

    private final PostsQueryGateway postsQueryGateway;

    public LoadPostsUsecase(PostsQueryGateway postsQueryGateway) {
        this.postsQueryGateway = postsQueryGateway;
    }

    @Override
    public Post loadById(Integer id) {
        return postsQueryGateway.loadById(id).orElseThrow(() -> new RuntimeException("Post with given id not found " + id));
    }

    @Override
    public Page<Post> loadPage(PageRequest pageRequest) {
        return postsQueryGateway.loadPage(pageRequest);
    }
}
