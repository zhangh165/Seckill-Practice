package com.zhh1011.miaosad.business.entity;

import lombok.Data;

@Data
public class Message {
    private int id;
    private String message;

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }
}
