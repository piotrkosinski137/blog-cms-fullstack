package com.blogen.posts.proxy;

import com.blogen.posts.usecase.DeletePosts;
import com.blogen.posts.usecase.gateway.PostsCommandGateway;
import com.blogen.posts.usecase.impl.DeletePostsUsecase;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DeletePostsProxy implements DeletePosts {

    private DeletePosts deletePosts;

    public DeletePostsProxy(PostsCommandGateway postsCommandGateway) {
        deletePosts = new DeletePostsUsecase(postsCommandGateway);
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        deletePosts.deleteById(id);
    }
}
