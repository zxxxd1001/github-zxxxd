package git.zxxxd;

import git.zxxxd.facade.TestFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringAppModule.class)
public class SpringModuleTest {
    @Resource
    public TestFacade testFacade;

    @Test
    public void test(){
        testFacade.getTest();
    }
}
