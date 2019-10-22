package com.blogen.posts.domain;

import com.blogen.categories.domain.Category;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "IMAGE_NAME")
    private String imageName;

    @Column(name = "ARTICLE")
    private String article;

    @Column(name = "LOCAL_DATE_ADDED")
    private LocalDateTime localDateAdded;

    @ManyToOne
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    private Post() {
    }

    public Post(String title, String imageName, String article, LocalDateTime localDateAdded, Category category) {
        this.title = title;
        this.imageName = imageName;
        this.article = article;
        this.localDateAdded = localDateAdded;
        this.category = category;
    }

    public String getImageName() {
        return imageName;
    }

    public String getArticle() {
        return article;
    }

    public LocalDateTime getLocalDateAdded() {
        return localDateAdded;
    }

    public Category getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", imageName='" + imageName + '\'' +
                ", article='" + article + '\'' +
                ", localDateAdded=" + localDateAdded +
                ", category=" + category +
                '}';
    }
}
