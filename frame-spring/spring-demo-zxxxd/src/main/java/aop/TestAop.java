package aop;

import aop.test.dao.PersonServerImpl;
import aop.test.service.PersonServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAop.xml");
        PersonServer a=ac.getBean("personServerImpl",PersonServer.class);
        a.save("asd");
    }
}
