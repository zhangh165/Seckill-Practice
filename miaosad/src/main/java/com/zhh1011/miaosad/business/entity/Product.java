package com.zhh1011.miaosad.business.entity;

import lombok.Data;
@Data
public class Product {
    private int id;
    private String name;
    private int number;
    private int version;

    public Product(int id, String name, int number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public Product(int id, String name, int number, int version) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.version = version;
    }

    public Product(int id) {
        this.id = id;
    }
}
