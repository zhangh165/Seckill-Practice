package com.zhh1011.miaosad.business.repository;

import com.zhh1011.miaosad.business.entity.Order;
import com.zhh1011.miaosad.business.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class ShoppingRepositoryTest {
    @Autowired
    private  ShoppingRepository shoppingRepository;

    @Test
    void buy() {
        Order order = new Order();
        order.setNumbers(8);
        order.setProductId(1);
        order.setUserId(1);
        shoppingRepository.buy(order);
        selectAllOrder();
    }

    @Test
    void checkProduct() {
        System.out.println(shoppingRepository.checkProduct(new Product(1,"Test",0)));
    }

    @Test
    void updateProduct() {
        Product product = new Product(1,"Test",21);
        shoppingRepository.updateProduct(product);
        checkProduct();
    }

    @Test
    void selectAllOrder(){
        ArrayList<Order> list = shoppingRepository.selectAllOrder();
        for(Order order:list){
            System.out.println(order);
        }
    }
}