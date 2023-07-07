package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.ProductDto;
import com.example.shoppingmall.dto.ProductUpdateDto;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void productSave(ProductDto productDto){
        Product product = new Product(productDto.getProduct_name(), productDto.getCity(), productDto.getPrice(), productDto.getDescription(), productDto.getImgUrl());
        productRepository.save(product);
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
    }

    public Product findProduct(Long id){
        return productRepository.findById(id).get();
    }

    @Transactional
    public void editProduct(Long id, ProductUpdateDto productDto){
        Product product = productRepository.findById(id).orElseThrow(NoSuchElementException::new);
        product.updateCategory(productDto.getProduct_name(), productDto.getCity(), productDto.getPrice()
        , productDto.getDescription(), productDto.getImgUrl());
        productRepository.save(product);
    }


}
