package git.jsr330;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JSR330Module.class)
public class JSR330Test {

    @Inject
    private JsrService jsrService;


    @Test
    public void test(){
        jsrService.save();
    }
}
