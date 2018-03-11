package git.zxxxd.spring.bean;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;

public class TestBean {
    @Test
    public void test(){
        AbstractApplicationContext ac= new ClassPathXmlApplicationContext("applicationContextBean.xml");
        GregorianCalendar c=ac.getBean("c1",GregorianCalendar.class);
        System.out.println(c);
        Date d1=ac.getBean("date",Date.class);
        System.out.println("d1:"+d1+" "+d1.hashCode());
        Date d2=ac.getBean("date",Date.class);
        System.out.println("d2"+d2+" "+d2.hashCode());
        System.out.println("获取的d1和d2是否是同一对象："+(d1==d2)+"");
        System.out.println();

        System.out.println(ac.getBean("constructor",Person.class));
        System.out.println(ac.getBean("message",MessageBean.class));
        System.out.println(ac.getBean("messageTwo",MessageBean.class));

        BeanLifecycle bl=ac.getBean("beanLifecycle",BeanLifecycle.class);
        bl.execute();
        ac.close();
    }
}
