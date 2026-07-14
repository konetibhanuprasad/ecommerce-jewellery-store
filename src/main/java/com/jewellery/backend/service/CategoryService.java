package com.jewellery.backend.service;

import com.jewellery.backend.entity.Category;
import com.jewellery.backend.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Add Category
    public Category addCategory(Category category) {

        if (categoryRepository.findByName(category.getName()).isPresent()) {
            throw new RuntimeException("Category already exists");
        }

        return categoryRepository.save(category);
    }

    // Get All Categories
    public List<Category> getAllCategories() {

        return categoryRepository.findAll();

    }

    // Update Category
    public Category updateCategory(String id, Category updatedCategory) {

        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        existingCategory.setName(updatedCategory.getName());
        existingCategory.setDescription(updatedCategory.getDescription());

        return categoryRepository.save(existingCategory);
    }
    // Delete Category
    public String deleteCategory(String id) {

        Category category = categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));

        categoryRepository.delete(category);

        return "Category Deleted Successfully";
    }

    // Get Category by ID
    public Category getCategoryById(String id) {

        return categoryRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Category not found"));
    }
}