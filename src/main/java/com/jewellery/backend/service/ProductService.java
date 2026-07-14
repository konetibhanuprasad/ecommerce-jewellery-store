package com.jewellery.backend.service;

import com.jewellery.backend.entity.Product;
import com.jewellery.backend.repository.ProductRepository;
import org.springframework.stereotype.Service;
import com.jewellery.backend.repository.CategoryRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {

        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    // Add Product
    public Product addProduct(Product product) {

        if (!categoryRepository.existsById(product.getCategoryId())) {
            throw new RuntimeException("Category does not exist");
        }

        return productRepository.save(product);

    }

    // Get All Products
    public List<Product> getAllProducts() {

        return productRepository.findAll();

    }

    // Get Products By Category
    public List<Product> getProductsByCategory(String categoryId) {

        return productRepository.findByCategoryId(categoryId);
    }
    // Update Product
    public Product updateProduct(String id, Product updatedProduct) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        if (!categoryRepository.existsById(updatedProduct.getCategoryId())) {
            throw new RuntimeException("Category does not exist");
        }

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setStock(updatedProduct.getStock());
        existingProduct.setImageUrl(updatedProduct.getImageUrl());
        existingProduct.setCategoryId(updatedProduct.getCategoryId());

        return productRepository.save(existingProduct);
    }
    // Delete Product
    public String deleteProduct(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        productRepository.delete(product);

        return "Product Deleted Successfully";
    }
}