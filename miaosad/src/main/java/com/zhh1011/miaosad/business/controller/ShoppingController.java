package com.zhh1011.miaosad.business.controller;

import com.zhh1011.miaosad.business.entity.Message;
import com.zhh1011.miaosad.business.entity.Order;
import com.zhh1011.miaosad.business.entity.Product;
import com.zhh1011.miaosad.business.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dsa44
 * @apiNote 购买api
 */
@RestController
@RequestMapping("/shopping")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return shoppingService.getDetail(id);
    }

    @PostMapping
    public Message buyProduct(@RequestBody Order order){
        Message message;
        try{
            shoppingService.buyProduct(order);
            message = new Message(0,"Success");
        }catch (Exception e){
            message = new Message(1,"Failed");
        }
        return message;
    }
}
