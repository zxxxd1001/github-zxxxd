package git.zxxxd.spring.aop;

import git.zxxxd.spring.aop.annotation.MatchingAop;
import git.zxxxd.spring.aop.dao.TestDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContextAop.xml");
        TestDao td = ac.getBean("testDao", TestDao.class);
        td.save();
        System.out.println("---------------");
        MatchingAop ma = ac.getBean("matchingAop", MatchingAop.class);
        ma.test();
        System.out.println("---------------");
        ma.set(1, 2);
        System.out.println("---------------");
        ma.testEx();
    }
}
