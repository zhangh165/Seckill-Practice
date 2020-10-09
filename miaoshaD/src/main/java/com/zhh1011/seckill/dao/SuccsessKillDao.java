package com.zhh1011.seckill.dao;

import com.zhh1011.seckill.entity.SuccessKill;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 购买明细dao
 */
@Repository
public interface SuccsessKillDao {
    /**
     * 插入购买明细（需过滤重复)
     * @param userPhone 用户电话
     * @param seckillId 秒杀商品id
     * @return
     */
    int insertSuccessKill(@Param("userPhone") long userPhone, @Param("seckillId") long seckillId);

    /**
     * 根据id查询successKilled并携带秒杀产品对象实体
     * @param seckillID
     * @return
     */
    SuccessKill queryById(@Param("seckillId")long seckillID,@Param("userPhone")long userPhone);

}
