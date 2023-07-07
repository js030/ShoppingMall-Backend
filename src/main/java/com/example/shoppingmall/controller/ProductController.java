package com.example.shoppingmall.controller;

import com.example.shoppingmall.dto.ProductDto;
import com.example.shoppingmall.dto.ProductUpdateDto;
import com.example.shoppingmall.entity.Product;
import com.example.shoppingmall.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class ProductController {


    private final ProductService productService;


    @PostMapping("api/shopping/save")
    @ResponseBody
    public ResponseEntity productSave(@RequestBody ProductDto productDto){
        log.info(productDto.getProduct_name());
        log.info(productDto.getCity());
        productService.productSave(productDto);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("api/shopping/update")
    @ResponseBody
    public ResponseEntity productUpdate(@RequestBody ProductUpdateDto productUpdateDto){

        log.info(productUpdateDto.getId());
        log.info(productUpdateDto.getCity());
        productService.editProduct(Long.parseLong(productUpdateDto.getId()), productUpdateDto);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/api/shopping/getall")
    @ResponseBody
    public ResponseEntity<List<Product>> allProduct(){
        List<Product> allProduct = productService.findAllProduct();
        return ResponseEntity.ok(allProduct);
    }

    @PostMapping("/api/shopping/delete")
    @ResponseBody
    public ResponseEntity deleteProduct(@RequestParam String id){
        Long delete_id = Long.parseLong(id);
        productService.deleteProduct(delete_id);
        return ResponseEntity.ok(null);
    }

}
