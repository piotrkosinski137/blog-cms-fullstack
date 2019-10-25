package com.blogen.posts.usecase.impl;

import com.blogen.posts.usecase.DeletePosts;
import com.blogen.posts.usecase.gateway.PostsCommandGateway;

public class DeletePostsUsecase implements DeletePosts {

    private final PostsCommandGateway postsCommandGateway;

    public DeletePostsUsecase(PostsCommandGateway postsCommandGateway) {
        this.postsCommandGateway = postsCommandGateway;
    }

    @Override
    public void deleteById(Integer id) {
        postsCommandGateway.deleteById(id);
    }
}
