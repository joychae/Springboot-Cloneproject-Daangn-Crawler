package com.webproject.clone_project_daangn.service;

import com.webproject.clone_project_daangn.model.dto.ProductRequestDto;
import com.webproject.clone_project_daangn.model.entity.Product;
import com.webproject.clone_project_daangn.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public Product findProductDetail(String id) {
        return productRepository.findByDaangnProductId(id);
    }

    public List<Product> find_hot(String want){
        System.out.println(want);
        return productRepository.findByRegionContaining(want);
    }

    public void createProduct(ProductRequestDto requestDto){
        Product product = new Product(requestDto);
        productRepository.save(product);
    }

    public List<Product> searchProduct(String keyword) {
        List<Product> searchlist = new ArrayList<>();
        searchlist.addAll(productRepository.findByNicknameContaining(keyword));
        searchlist.addAll(productRepository.findByTitleContaining(keyword));
        searchlist.addAll(productRepository.findByContentsContaining(keyword));
        return searchlist;
    }

}
