package com.zhh1011.seckill.dao.cache;

import com.zhh1011.seckill.dao.SeckillDao;
import com.zhh1011.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillRedisDaoTest {

    @Autowired
    private SeckillRedisDao seckillRedisDao;
    @Autowired
    private SeckillDao seckillDao;
    @Test
    public void testSeckillCacheDao() {
        Long seckillId = 1l;
        Seckill seckill = seckillRedisDao.getSeckillFromCache(seckillId);
        if(seckill == null){
            seckill = seckillDao.queryById(seckillId);
            if(seckill!=null){
                seckillRedisDao.putSeckill(seckill);
                System.out.println(seckill);
                seckill = seckillRedisDao.getSeckillFromCache(seckillId);
                System.out.println(seckill);
            }
        }
    }
}