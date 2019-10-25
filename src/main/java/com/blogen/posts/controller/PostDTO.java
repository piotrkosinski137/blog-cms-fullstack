package com.blogen.posts.controller;

import java.util.Objects;

public class PostDTO {

    private Integer id;

    private String title;

    private String imageName;

    private String article;

    private String localDateAdded;

    private String categoryTitle;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImageName() {
        return imageName;
    }

    public String getArticle() {
        return article;
    }

    public String getLocalDateAdded() {
        return localDateAdded;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public void setLocalDateAdded(String localDateAdded) {
        this.localDateAdded = localDateAdded;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return Objects.equals(id, postDTO.id) &&
                Objects.equals(title, postDTO.title) &&
                Objects.equals(imageName, postDTO.imageName) &&
                Objects.equals(article, postDTO.article) &&
                Objects.equals(localDateAdded, postDTO.localDateAdded) &&
                Objects.equals(categoryTitle, postDTO.categoryTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, imageName, article, localDateAdded, categoryTitle);
    }
}
