package com.blogen.categories.gateway;

import com.blogen.categories.domain.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
}
