package com.zhh1011.miaosad.business.entity;

import lombok.Data;

@Data
public class Order {
    private int id;
    private int userId;
    private int productId;
    private int numbers;
}
