package com.example.products.Services;

import com.example.products.models.Product;
import com.example.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product findOne(int id) {
        return productRepository.findById(id).get();
    }

    public Product update(Product product) {
        return productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }


}
