package com.zhh1011.seckill.dao;

import com.zhh1011.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 商品信息dao
 * @author dsa44
 */
@Repository
public interface SeckillDao {
    /**
     * 减库存
     * @param seckillId 库存ID
     * @param killTime  创建时间
     * @return
     */
    int reduceNumber(@Param("seckillId")long seckillId,@Param("killTime")Date killTime);

    /**
     * 根据id查询秒杀对象
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询
     * @return
     */
    List<Seckill> queryAll(@Param("offet") int offet, @Param("limit")int limit);
}
