package com.zhh1011.seckill.service.impl;

import com.zhh1011.seckill.dto.Exposer;
import com.zhh1011.seckill.dto.SeckillExecution;
import com.zhh1011.seckill.entity.Seckill;
import com.zhh1011.seckill.exception.RepeatKillException;
import com.zhh1011.seckill.exception.SeckillCloseException;
import com.zhh1011.seckill.service.SeckillService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillServiceImplTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SeckillService seckillService;
    @Test
    public void getSeckillAll() {
        List<Seckill> list = seckillService.getSeckillAll();
        logger.info("list={}",list);
    }

    @Test
    public void getSeckillById() {
        Seckill seckill = seckillService.getSeckillById(1);
        logger.info("seckill={}",seckill);
    }

    @Test
    public void testSeckillLogic() {
        Exposer exposer = seckillService.exportSeckillUrl(1);
        if(exposer.isExposer()) {
            logger.info("exposer={}", exposer);
            String md5 = exposer.getMd5();
            try {
                long seckillId = 1;
                SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId, 13204450020l, md5);
                logger.info("seckillExecution={}", seckillExecution);
            }catch (RepeatKillException e){
                logger.error(e.getMessage());
            }catch (SeckillCloseException e){
                logger.error(e.getMessage());
            }
        }else {
            logger.warn("exposer={}", exposer);
        }
    }
}