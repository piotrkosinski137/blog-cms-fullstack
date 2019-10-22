package com.blogen.categories.usecase;

import com.blogen.categories.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface LoadCategories {
    Page<Category> loadPage(PageRequest pageRequest);
    Category loadById(Integer id);
}
