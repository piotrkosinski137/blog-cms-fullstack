package com.blogen.categories.controller;

import com.blogen.categories.domain.Category;
import com.blogen.categories.usecase.LoadCategories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class LoadCategoriesController {

    private final LoadCategories loadCategories;

    public LoadCategoriesController(LoadCategories loadCategories) {
        this.loadCategories = loadCategories;
    }

    @GetMapping
    public Page<Category> loadPage(@RequestParam int page, @RequestParam int size) {
        return loadCategories.loadPage(PageRequest.of(page, size));
    }

    @GetMapping(value = "/{id}")
    public Category loadById(@PathVariable Integer id) {
        return loadCategories.loadById(id);
    }
}
