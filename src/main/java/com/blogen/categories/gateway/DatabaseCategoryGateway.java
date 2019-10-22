package com.blogen.categories.gateway;

import com.blogen.categories.domain.Category;
import com.blogen.categories.usecase.gateways.CategoriesCommandGateway;
import com.blogen.categories.usecase.gateways.CategoriesQueryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseCategoryGateway implements CategoriesQueryGateway, CategoriesCommandGateway {

    private final CategoryRepository categoryRepository;

    public DatabaseCategoryGateway(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Category> loadPage(PageRequest pageRequest) {
        return categoryRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Category> loadById(Integer id) {
        return categoryRepository.findById(id);
    }
}
