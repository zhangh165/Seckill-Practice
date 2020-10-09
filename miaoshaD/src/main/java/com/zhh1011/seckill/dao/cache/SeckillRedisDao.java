package com.zhh1011.seckill.dao.cache;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.zhh1011.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class SeckillRedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    private Gson gson =new Gson();

    public Seckill getSeckillFromCache(Long seckillId){
        try{
            String key = "seckill:"+seckillId;
            String seckillJson = redisTemplate.opsForValue().get(key);
            if(seckillJson!= null){
                Seckill seckill = gson.fromJson(seckillJson,Seckill.class);
                return seckill;
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    public void putSeckill(Seckill seckill){
        try {
            String key = "seckill:" + seckill.getSeckillId();
            String seckillJson = gson.toJson(seckill);
            redisTemplate.opsForValue().set(key,seckillJson,1,TimeUnit.HOURS);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }
}
