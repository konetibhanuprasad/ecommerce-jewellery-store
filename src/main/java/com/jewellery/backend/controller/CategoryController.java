package com.jewellery.backend.controller;

import com.jewellery.backend.entity.Category;
import com.jewellery.backend.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Add Category
    @PostMapping
    public Category addCategory(@RequestBody Category category) {

        return categoryService.addCategory(category);

    }

    // Get All Categories
    @GetMapping
    public List<Category> getAllCategories() {

        return categoryService.getAllCategories();

    }

}