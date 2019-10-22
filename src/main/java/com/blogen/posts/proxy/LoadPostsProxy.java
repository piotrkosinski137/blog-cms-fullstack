package com.blogen.posts.proxy;

import com.blogen.posts.domain.Post;
import com.blogen.posts.usecase.LoadPosts;
import com.blogen.posts.usecase.gateway.PostsQueryGateway;
import com.blogen.posts.usecase.impl.LoadPostsUsecase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LoadPostsProxy implements LoadPosts {

    private LoadPosts loadPosts;

    public LoadPostsProxy(PostsQueryGateway postsQueryGateway) {
        loadPosts = new LoadPostsUsecase(postsQueryGateway);
    }

    @Override
    public Post loadById(Integer id) {
        return loadPosts.loadById(id);
    }

    @Override
    public Page<Post> loadPage(PageRequest pageRequest) {
        return loadPosts.loadPage(pageRequest);
    }
}
