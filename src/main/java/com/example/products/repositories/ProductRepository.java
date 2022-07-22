package com.example.products.repositories;

import com.example.products.models.Product;
import com.example.products.models.Store;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByStore(Store store, Sort sort);

}