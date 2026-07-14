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
    // Get Category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable String id) {

        return categoryService.getCategoryById(id);

    }
    // Update Category
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable String id,
                                   @RequestBody Category category) {

        return categoryService.updateCategory(id, category);

    }
    // Delete Category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable String id) {

        return categoryService.deleteCategory(id);

    }

}