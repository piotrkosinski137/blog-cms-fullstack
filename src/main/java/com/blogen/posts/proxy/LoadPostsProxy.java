package com.blogen.posts.proxy;

import com.blogen.posts.domain.Post;
import com.blogen.posts.usecase.LoadPosts;
import com.blogen.posts.usecase.gateway.PostsQueryGateway;
import com.blogen.posts.usecase.impl.LoadPostsUsecase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class LoadPostsProxy implements LoadPosts {

    private LoadPosts loadPosts;

    public LoadPostsProxy(PostsQueryGateway postsQueryGateway) {
        loadPosts = new LoadPostsUsecase(postsQueryGateway);
    }

    @Transactional
    @Override
    public Post loadById(Integer id) {
        return loadPosts.loadById(id);
    }

    @Transactional
    @Override
    public Page<Post> loadPage(PageRequest pageRequest) {
        return loadPosts.loadPage(pageRequest);
    }
}
