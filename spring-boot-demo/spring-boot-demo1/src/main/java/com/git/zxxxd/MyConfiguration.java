package com.git.zxxxd;

import com.git.zxxxd.service.UserService;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Configuration：指明当前类是一个配置类；就是来替代之前的Spring配置文件
 *
 * 在配置文件中用<bean><bean/>标签添加组件
 *
 */
@Configuration
//@EnableWebMvc
public class MyConfiguration extends WebMvcConfigurerAdapter {
    //将方法的返回值添加到容器中；容器中这个组件默认的id就是方法名
    @Bean
    public UserService userService(){
        System.out.println("配置类@Bean给容器中添加组件了...");
        return new UserService();
    }
}
