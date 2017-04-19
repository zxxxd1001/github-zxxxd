package the.life.cycle;

import bean.the.life.cycle.AppMoudle;
import bean.the.life.cycle.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangxuedong on 2017/4/12.
 */
public class TestAppMoudle {
    @Test
    public void test(){
        AbstractApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppMoudle.class);
        Person p=applicationContext.getBean("persons",Person.class);
        System.out.println(p);
        applicationContext.close();
    }
}
