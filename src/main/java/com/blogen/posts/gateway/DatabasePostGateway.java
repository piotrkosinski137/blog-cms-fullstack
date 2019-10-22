package com.blogen.posts.gateway;

import com.blogen.posts.domain.Post;
import com.blogen.posts.usecase.gateway.PostsCommandGateway;
import com.blogen.posts.usecase.gateway.PostsQueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabasePostGateway implements PostsQueryGateway, PostsCommandGateway {

    private final PostRepository postRepository;

    public DatabasePostGateway(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> loadById(Integer id) {
        return postRepository.findById(id);
    }

    @Override
    public Page<Post> loadPage(PageRequest pageRequest) {
        return postRepository.findAll(pageRequest);
    }
}
