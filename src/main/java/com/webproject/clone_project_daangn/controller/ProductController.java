package com.webproject.clone_project_daangn.controller;

import com.webproject.clone_project_daangn.model.entity.Product;
import com.webproject.clone_project_daangn.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.type.NullType;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping(value = {"/api/region/{val2}/{val3}", "/api/region/{val2}"})
    public List<Product> find_hot( @PathVariable String val2, @PathVariable(required = false) String val3){
        if (val3 == null){
            return productService.find_hot(val2);
        }
        String want = val2 +" "+val3;
        return productService.find_hot(want);
    }

}