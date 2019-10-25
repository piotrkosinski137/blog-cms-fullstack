package com.blogen.posts.controller;

import com.blogen.posts.usecase.DeletePosts;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("posts")
public class DeletePostController {

    private final DeletePosts deletePosts;

    public DeletePostController(DeletePosts deletePosts) {
        this.deletePosts = deletePosts;
    }

    @DeleteMapping()
    public void deleteById(@RequestParam Integer id) {
        deletePosts.deleteById(id);
    }
}
