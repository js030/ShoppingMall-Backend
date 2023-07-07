package com.example.shoppingmall.dto;

import lombok.Data;

@Data
public class ProductUpdateDto {

    private String id;

    private String product_name;

    private String city;

    private String price;

    private String description;

    private String imgUrl;
}
