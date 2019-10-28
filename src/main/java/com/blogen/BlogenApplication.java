package com.blogen;

import com.blogen.categories.domain.Category;
import com.blogen.categories.gateway.CategoryRepository;
import com.blogen.posts.domain.Post;
import com.blogen.posts.gateway.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class BlogenApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(BlogenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category1 = categoryRepository.save(new Category("category1", LocalDate.now()));
        Category category2 = categoryRepository.save(new Category("category2", LocalDate.now()));
        Category category3 = categoryRepository.save(new Category("category3", LocalDate.now()));

        postRepository.save(new Post("How to be cool","img.jpg","lorem23...", LocalDateTime.now(), category1));
        postRepository.save(new Post("Be or Not to be","img.jpg","lorem23...", LocalDateTime.now(), category1));
        postRepository.save(new Post("3How to be cool","img.jpg","lorem23...", LocalDateTime.now(), category1));
        postRepository.save(new Post("444Be or Not to be","img.jpg","lorem23...", LocalDateTime.now(), category1));
        postRepository.save(new Post("123How to be cool","img.jpg","lorem23...", LocalDateTime.now(), category1));
        postRepository.save(new Post("123Be or Not to be","img.jpg","lorem23...", LocalDateTime.now(), category1));
        postRepository.save(new Post("1233How to be cool","img.jpg","lorem23...", LocalDateTime.now(), category1));
        postRepository.save(new Post("123444Be or Not to be","img.jpg","lorem23...", LocalDateTime.now(), category1));
    }
}
