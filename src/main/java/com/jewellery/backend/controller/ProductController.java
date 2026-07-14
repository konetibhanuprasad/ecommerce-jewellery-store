package com.jewellery.backend.controller;

import com.jewellery.backend.entity.Product;
import com.jewellery.backend.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Add Product
    @PostMapping
    public Product addProduct(@RequestBody Product product) {

        return productService.addProduct(product);

    }

    // Get All Products
    @GetMapping
    public List<Product> getAllProducts() {

        return productService.getAllProducts();

    }

    // Get Products By Category
    @GetMapping("/category/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable String categoryId) {

        return productService.getProductsByCategory(categoryId);

    }
    // Update Product
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable String id,
                                 @RequestBody Product product) {

        return productService.updateProduct(id, product);
    }
    // Delete Product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id) {

        return productService.deleteProduct(id);

    }
}