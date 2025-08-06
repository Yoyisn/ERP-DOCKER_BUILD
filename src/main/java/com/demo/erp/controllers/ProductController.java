package com.demo.erp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.demo.erp.services.ProductService;

import lombok.RequiredArgsConstructor;
import com.demo.erp.dto.ProductDto;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("apiProducts")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProducts")
    public List<ProductDto> getAllProducts() {
        return productService.findAllProducts();
    };

    @PostMapping("/createProduct")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    };

};