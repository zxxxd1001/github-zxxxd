package demo.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledTaskTest {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
    }
}
