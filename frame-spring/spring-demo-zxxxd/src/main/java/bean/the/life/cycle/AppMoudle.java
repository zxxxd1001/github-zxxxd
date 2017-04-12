package bean.the.life.cycle;

import bean.entity.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppMoudle {

    @Bean
    public MyBeanFactoryPostProcessor beanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }
    @Bean
    public MyBeanPostProcessor beanPostProcessor(){
        return new MyBeanPostProcessor();
    }
    @Bean
    public MyInstantiationAwareBeanPostProcessor instantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }

    @Bean
    @Scope(scopeName = "singleton")
    public Person person(){
        Person person=new Person();
        person.setName("张三");
        person.setAddress("北京");
        person.setPhone(1234556);
        return person;
    }
}
