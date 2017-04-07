package sample.soundsystemTest;

import bean.entity.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sample.soundsystem.CDPlayerConfig;
import sample.soundsystem.CompactDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;

    @Test
    public void play() {
        cd.play();
        System.out.println(cd);

        /*
         * 在传统 XML 方法中，您可使用 ClassPathXmlApplicationContext 类来加载外部 XML 上下文文件。
         * 但在使用基于 Java 的配置时，有一个 AnnotationConfigApplicationContext 类。
         * AnnotationConfigApplicationContext 类是 ApplicationContext 接口的一个实现，使您能够注册所注释的配置类。
         * 此处的配置类是使用 @Configuration 注释声明的 CDPlayerConfig。
         * 在注册了所述类之后，@Bean 注释的方法返回的所有 bean 类型也会得到注册
         *
         * 还可以使用所述上下文类的 register 方法来注册配置类
         * ApplicationContext ctx = new AnnotationConfigApplicationContext();
         *    ctx.register(AppContext.class)
         */
        ApplicationContext ac=new AnnotationConfigApplicationContext(CDPlayerConfig.class);
        Phone phone=ac.getBean("phone",Phone.class);
        System.out.println(phone);
    }
}  