package com.example.products.controllers;
import com.example.products.Services.ProductService;
import com.example.products.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<Product> showProducts() {
        return productService.getAll();
    }

    @GetMapping("/product/{id}")
    public Product showOneProduct(@PathVariable("id") int id) {
        return productService.findOne(id);
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/product/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") int id) {
        Product newProduct = productService.findOne(id);
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        return productService.create(newProduct);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
    }

}