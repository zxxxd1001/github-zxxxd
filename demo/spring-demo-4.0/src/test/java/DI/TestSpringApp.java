package DI;

import com.git.zxxxd.SpringApp;
import com.git.zxxxd.domain.DI.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;

/**
 *  SpringJUnit4ClassRunner 测试开始的时候自动创建spring的应用上下文
 *
 *  ContextConfiguration指定从那个类加载配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringApp.class)
public class TestSpringApp {
    @Autowired
    private CompactDisc compactDisc;

    @Autowired
    @Qualifier("getDate")
    private Date date;

    @Test
    public void test(){
        compactDisc.play();
        System.out.println(date);
    }
}
