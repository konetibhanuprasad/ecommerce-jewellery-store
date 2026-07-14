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
}