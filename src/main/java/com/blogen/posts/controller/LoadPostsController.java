package com.blogen.posts.controller;

import com.blogen.posts.domain.Post;
import com.blogen.posts.usecase.LoadPosts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("posts")
public class LoadPostsController {

    private final LoadPosts loadPosts;

    public LoadPostsController(LoadPosts loadPosts) {
        this.loadPosts = loadPosts;
    }

    @GetMapping("/{id}")
    public Post loadById(@PathVariable Integer id) {
        return loadPosts.loadById(id);
    }


    @GetMapping
    public Page<Post> loadPage(@RequestParam int page, @RequestParam int size) {
        return loadPosts.loadPage(PageRequest.of(page,size));
    }
}
