package com.blogen.categories.proxy;

import com.blogen.categories.domain.Category;
import com.blogen.categories.usecase.LoadCategories;
import com.blogen.categories.usecase.gateways.CategoriesQueryGateway;
import com.blogen.categories.usecase.impl.LoadCategoriesUsecase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class LoadCategoriesProxy implements LoadCategories {

    private LoadCategories loadCategories;

    public LoadCategoriesProxy(CategoriesQueryGateway categoriesQueryGateway) {
        loadCategories = new LoadCategoriesUsecase(categoriesQueryGateway);
    }

    @Override
    public Page<Category> loadPage(PageRequest pageRequest) {
        return loadCategories.loadPage(pageRequest);
    }

    @Override
    public Category loadById(Integer id) {
        return loadCategories.loadById(id);
    }
}
