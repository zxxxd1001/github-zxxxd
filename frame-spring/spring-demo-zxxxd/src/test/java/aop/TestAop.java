package aop;

import aop.test.service.PersonServer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppModule.class)
public class TestAop {

    @Resource
    private PersonServer personServer;

    @Test
    public void test(){
        personServer.save("nasd");
        System.out.println("---------------------");
        personServer.getPersonName(12);
    }
}
