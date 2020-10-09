package com.zhh1011.seckill.dao;

import com.zhh1011.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillDaoTest {

    @Autowired
    SeckillDao seckillDao;
    @Test
    public void reduceNumber() {
        int updatecount = seckillDao.reduceNumber(1,new Date());
        System.out.println(updatecount);
    }

    @Test
    public void queryById() {
        long id = 1;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        List<Seckill> list = seckillDao.queryAll(0,20);
        for(Seckill seckill:list){
            System.out.println(seckill);
        }
    }
}