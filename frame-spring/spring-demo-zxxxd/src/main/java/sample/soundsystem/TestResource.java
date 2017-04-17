package sample.soundsystem;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TestResource implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public void testResource() {
        System.out.println("--------@Resource 注解---------");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
     this.applicationContext=applicationContext;
    }

    public void testClasspath(){
        try {
            Resource resource=applicationContext.getResource("classpath:jdbc.properties");
            System.out.println("通过classpath读取文件："+resource.getFilename());
            System.out.println("classpath完整路径："+resource.getURI().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testUrl(){
        Resource resource = applicationContext.getResource("http:https://baidu.com");
//        System.out.println(resource.getFilename());
//        System.out.println(resource.getURI().getPath());
    }
}
