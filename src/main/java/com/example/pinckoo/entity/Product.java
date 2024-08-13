package com.example.pinckoo.entity;

import lombok.Data;

@Data
public class Product {
    private Integer id;
    private String nameZh;
    private String nameEn;
    private String image;
    private String images;
    private String model;
    private String type;
    private Boolean isNew;
    private Boolean isHot;
    private String weight;
    private String size;
    private String material;
    private String materialEn;
    private String function;
    private String functionEn;
}
