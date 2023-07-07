package com.example.shoppingmall.dto;

import lombok.Data;

@Data
public class ProductDto {
    private String product_name;

    private String city;

    private String price;

    private String description;

    private String imgUrl;
}
