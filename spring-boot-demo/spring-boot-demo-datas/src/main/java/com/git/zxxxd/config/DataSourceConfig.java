package com.git.zxxxd.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    //主数据源配置
    @Primary // 表示这个数据源是默认数据源, 这个注解必须要加，因为不加的话spring将分不清楚那个为主数据源（默认数据源）
    @Bean("OneDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.one") //读取application.yml中的配置参数映射成为一个对象
    public DataSource OneDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("TwoDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.two") //读取application.yml中的配置参数映射成为一个对象
    public DataSource getTwoDataSource(){
        return DataSourceBuilder.create().build();
    }

}
