package com.git.zxxxd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(value = "com.git.zxxxd.mapper")
@EnableCaching
public class SpringBootDemoDatasApplication {
    /**
     * 分包方式整合
     *
     CREATE TABLE `users` (
     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
     `name` varchar(25) NOT NULL COMMENT '姓名',
     `age` int(2) DEFAULT NULL COMMENT '年龄',
     `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别：0-男，1-女',
     `addr` varchar(100) DEFAULT NULL COMMENT '地址',
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDatasApplication.class, args);
    }

}
