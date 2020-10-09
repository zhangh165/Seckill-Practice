package com.zhh1011.miaosad.business.repository;

import com.zhh1011.miaosad.business.entity.Order;
import com.zhh1011.miaosad.business.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Mapper
@Repository
public interface ShoppingRepository {
    /**
     *
     * @param order
     */
    @Insert("insert into t_order(user_id,product_id,numbers) values(#{userId},#{productId},#{numbers})")
    public void buy(Order order);

    @Select("select * from t_order")
    @Results(
            {
                    @Result(property = "id",column = "user_id"),
                    @Result(property = "productId",column = "product_id"),
                    @Result(property = "numbers",column = "numbers")
            }
    )
    public ArrayList<Order> selectAllOrder();
    /**
     *
     * @param product
     */
    @Select("select * from t_product where id = #{id}")
    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "number",column = "number"),
            @Result(property = "version",column = "version")
    })
    public Product checkProduct(Product product);

    @Update("update t_product " +
            "set number = #{number},version = #{version}+1 " +
            "where id=#{id} and version=#{version}")
    public boolean updateProduct(Product product);
}
