package com.blogen.categories.domain;

import com.blogen.posts.domain.Post;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") //solution to infinite recursion
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DATE_ADDED")
    private LocalDate dateAdded;

    @OneToMany(mappedBy = "category")
    private List<Post> posts;

    private Category() {
    }

    public Category(String title, LocalDate dateAdded) {
        this.title = title;
        this.dateAdded = dateAdded;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateAdded=" + dateAdded +
                ", posts=" + posts +
                '}';
    }
}
