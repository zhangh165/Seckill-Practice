package com.zhh1011.seckill.service;

import com.zhh1011.seckill.dto.Exposer;
import com.zhh1011.seckill.dto.SeckillExecution;
import com.zhh1011.seckill.entity.Seckill;
import com.zhh1011.seckill.exception.RepeatKillException;
import com.zhh1011.seckill.exception.SeckillCloseException;
import com.zhh1011.seckill.exception.SeckillException;

import java.util.List;

/**
 * 秒杀业务接口类
 */
public interface SeckillService {

    /**
     * 获取所有秒杀商品
     * @return
     */
    List<Seckill> getSeckillAll();

    /**
     * 获取单个秒杀商品
     * @param seckillId 秒杀商品id
     * @return
     */
    Seckill getSeckillById(long seckillId);

    /**
     * 秒杀开启时输出秒杀地址
     * 否则输出系统当前时间
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws RepeatKillException,SeckillCloseException,SeckillException;
}
