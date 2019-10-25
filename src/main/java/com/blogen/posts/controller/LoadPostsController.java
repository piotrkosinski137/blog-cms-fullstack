package com.blogen.posts.controller;

import com.blogen.commons.PageDTO;
import com.blogen.commons.Pages;
import com.blogen.posts.domain.Post;
import com.blogen.posts.usecase.LoadPosts;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("posts")
public class LoadPostsController {

    private final LoadPosts loadPosts;
    private final ModelMapper mapper = PostMapper.initialize();

    public LoadPostsController(LoadPosts loadPosts) {
        this.loadPosts = loadPosts;
    }

    @GetMapping("/{id}")
    public Post loadById(@PathVariable Integer id) {
        return loadPosts.loadById(id);
    }

    @GetMapping
    public PageDTO<PostDTO> loadPage(@RequestParam int page, @RequestParam int size) {
        Page<Post> posts = loadPosts.loadPage(PageRequest.of(page, size));
        return Pages.mapContent(posts, post -> mapper.map(post, PostDTO.class));
    }
}
