package com.blogen.categories.usecase.impl;

import com.blogen.categories.domain.Category;
import com.blogen.categories.usecase.LoadCategories;
import com.blogen.categories.usecase.gateways.CategoriesQueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class LoadCategoriesUsecase implements LoadCategories {

    private final CategoriesQueryGateway categoriesQueryGateway;

    public LoadCategoriesUsecase(CategoriesQueryGateway categoriesQueryGateway) {
        this.categoriesQueryGateway = categoriesQueryGateway;
    }

    @Override
    public Page<Category> loadPage(PageRequest pageRequest) {
        return categoriesQueryGateway.loadPage(pageRequest);
    }

    @Override
    public Category loadById(Integer id) {
        return categoriesQueryGateway.loadById(id).orElseThrow(() -> new RuntimeException("Category with given id " +
                "not found " + id));
    }
}
