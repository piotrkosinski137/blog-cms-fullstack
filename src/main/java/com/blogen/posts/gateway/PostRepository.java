package com.blogen.posts.gateway;

import com.blogen.posts.domain.Post;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Integer> {
}
