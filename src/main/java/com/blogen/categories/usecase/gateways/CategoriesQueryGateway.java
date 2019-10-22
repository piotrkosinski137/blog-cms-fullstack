package com.blogen.categories.usecase.gateways;

import com.blogen.categories.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface CategoriesQueryGateway {
    Page<Category> loadPage(PageRequest pageRequest);
    Optional<Category> loadById(Integer id);
}
