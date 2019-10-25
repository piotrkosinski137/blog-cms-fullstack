package com.blogen.categories.controller;

import java.time.LocalDate;
import java.util.List;

public class CategoryDTO {
    private Integer id;

    private String title;

    private LocalDate dateAdded;

    private List<PostOverview> posts;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public List<PostOverview> getPosts() {
        return posts;
    }

    public void setPosts(List<PostOverview> posts) {
        this.posts = posts;
    }
}


class PostOverview {
    private Integer id;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
