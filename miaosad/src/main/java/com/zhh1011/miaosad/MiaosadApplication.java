package com.zhh1011.miaosad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

// TODO: 2020/3/20 完成配置
@SpringBootApplication
@EnableSwagger2WebMvc
@EnableWebMvc
public class MiaosadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiaosadApplication.class, args);
    }

}
