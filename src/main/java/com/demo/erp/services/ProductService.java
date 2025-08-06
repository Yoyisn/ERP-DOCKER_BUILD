package com.demo.erp.services;

import org.springframework.beans.factory.annotation.Autowired;
import com.demo.erp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import com.demo.erp.models.Product;
import com.demo.erp.dto.ProductDto;
import java.util.stream.Collectors;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> findAllProducts () {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductDto::new)
                .collect(Collectors.toList());
    };

    public ProductDto createProduct(ProductDto request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(String.valueOf(request.getPrice()));
        product.setDescription(request.getDescription());
        product.setStock(String.valueOf(request.getStock()));

        Product savedProduct = productRepository.save(product);
        return new ProductDto(savedProduct);
    };

    public String deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            return "Product not found";
        } else {
            productRepository.deleteById(id);
            return "Product deleted";
        }
    };

};