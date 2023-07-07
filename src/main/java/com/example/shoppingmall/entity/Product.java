package com.example.shoppingmall.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String product_name;

    private String city;

    private String price;

    private String description;

    private String imgUrl;

    @Builder
    public Product(String product_name, String city, String price, String description, String imgUrl) {
        this.product_name = product_name;
        this.city = city;
        this.price = price;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    public void updateCategory(String product_name, String city, String price, String description, String url){
        this.product_name = product_name;
        this.city = city;
        this.price = price;
        this.description = description;
        this.imgUrl = url;
    }

}
