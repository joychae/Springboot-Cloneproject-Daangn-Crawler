package com.webproject.clone_project_daangn.repository;

import com.webproject.clone_project_daangn.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByDaangnProductId(String id);
    List<Product> findByRegionContaining(String want);
}