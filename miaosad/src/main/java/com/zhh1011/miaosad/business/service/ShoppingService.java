package com.zhh1011.miaosad.business.service;

import com.zhh1011.miaosad.business.entity.Order;
import com.zhh1011.miaosad.business.entity.Product;
import com.zhh1011.miaosad.business.repository.ShoppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingService {
    @Autowired
    private ShoppingRepository shoppingRepository;

    public boolean buyProduct(Order order) throws Exception{
        if(null == order){
            return false;
        }
        try {
            int id = order.getProductId();
            Product product = getDetail(id);

            int num = product.getNumber() - order.getNumbers();
            if(num < 0){
                throw new RuntimeException("超出额度");
            }
            product.setNumber(num);
            //乐观锁 版本号实现

            if(shoppingRepository.updateProduct(product)){
                shoppingRepository.buy(order);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return true; 
    }

    public Product getDetail(int id){
        return shoppingRepository.checkProduct(new Product(1));
    }
}
