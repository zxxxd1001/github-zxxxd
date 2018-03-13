package git.zxxxd.spring.aop;

import git.zxxxd.spring.aop.annotation.MatchingAop;
import git.zxxxd.spring.aop.dao.TestDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextAop.xml");
        ac.getBean("testDao", TestDao.class).save();
        System.out.println("---------------");
        ac.getBean("matchingAop", MatchingAop.class).test();
    }
}
