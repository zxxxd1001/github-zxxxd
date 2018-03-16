package com.git.zxxxd;

import com.git.zxxxd.config.ConfigApp;
import org.springframework.context.annotation.*;

import java.util.Date;


/**
 * @Configuration 注释位于类的顶端。它告知 Spring 容器这个类是一个拥有 bean 定义和依赖项的配置类。
 * @ComponentScan 开启扫描注解 装配bean
 */
@Configuration
@ComponentScan
@Import(ConfigApp.class)
@ImportResource("classpath:applicationContext.xml")
public class SpringApp {
}
