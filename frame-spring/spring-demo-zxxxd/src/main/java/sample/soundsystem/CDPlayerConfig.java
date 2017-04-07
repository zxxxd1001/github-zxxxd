package sample.soundsystem;

import bean.entity.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 注释位于类的顶端。它告知 Spring 容器这个类是一个拥有 bean 定义和依赖项的配置类。
 * @ComponentScan 开启扫描注解 装配bean
 */
@Configuration
@ComponentScan
public class CDPlayerConfig {

    /**
     * @Bean 注释用于定义 bean。
     *  上述注释位于实例化 bean 并设置依赖项的方法上方。
     *  方法名称与 bean id 或默认名称相同。
     * @return  该方法的返回类型是向 Spring 应用程序上下文注册的 bean
     */
    @Bean
    public Phone phone(){
        Phone phone=new Phone("i7","16G");
        return phone;
    }
}
