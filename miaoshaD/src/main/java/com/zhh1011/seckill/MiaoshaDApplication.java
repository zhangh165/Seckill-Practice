package com.zhh1011.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zhh1011.seckill.dao")
public class MiaoshaDApplication {
    public static void main(String[] args){
        SpringApplication.run(MiaoshaDApplication.class,args);
    }
}
