package com.zhh1011.seckill.dao;

import com.zhh1011.seckill.entity.SuccessKill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuccsessKillDaoTest {

    @Autowired
    private SuccsessKillDao succsessKillDao;

    @Test
    public void insertSuccessKill() {
        int inserCount = succsessKillDao.insertSuccessKill(13290878909l,1);
        System.out.println(inserCount);
    }

    @Test
    public void queryById() {
        SuccessKill successKill = succsessKillDao.queryById(1,13290878909l);
        System.out.println(successKill);
    }
}