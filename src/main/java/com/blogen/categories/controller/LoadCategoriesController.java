package com.blogen.categories.controller;

import com.blogen.categories.domain.Category;
import com.blogen.categories.usecase.LoadCategories;
import com.blogen.commons.PageDTO;
import com.blogen.commons.Pages;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categories")
public class LoadCategoriesController {

    private final LoadCategories loadCategories;
    private final ModelMapper mapper = CategoryMapper.initialize();

    public LoadCategoriesController(LoadCategories loadCategories) {
        this.loadCategories = loadCategories;
    }

    @GetMapping
    public PageDTO<CategoryDTO> loadPage(@RequestParam int page, @RequestParam int size) {
        Page<Category> categories = loadCategories.loadPage(PageRequest.of(page, size));
        return Pages.mapContent(categories, category -> mapper.map(category, CategoryDTO.class));
    }

    @GetMapping(value = "/{id}")
    public CategoryDTO loadById(@PathVariable Integer id) {
        Category category = loadCategories.loadById(id);
        return mapper.map(category, CategoryDTO.class);
    }
}
