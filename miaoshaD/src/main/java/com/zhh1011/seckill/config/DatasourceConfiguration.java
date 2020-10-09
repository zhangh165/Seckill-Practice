package com.zhh1011.seckill.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * c3p0连接池配置类
 */
@Configuration
public class DatasourceConfiguration {
    //设置Bean扫描
    @Bean(name="datasource")
    //指定value所指代的Bean为该对象
    @Qualifier(value = "datasource")
    @Primary
    //指定配置文件中的
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }
}
