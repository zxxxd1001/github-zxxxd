package demo.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WiselyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputService();
        context.close();
    }
}
