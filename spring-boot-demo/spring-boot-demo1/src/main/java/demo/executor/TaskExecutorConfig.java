package demo.executor;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@ComponentScan("demo.executor")
@EnableAsync   //开启异步
public class TaskExecutorConfig implements AsyncConfigurer {

    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor=new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);//线程池维护线程的最少数量
        taskExecutor.setMaxPoolSize(10);//线程池维护线程的最大数量
        taskExecutor.setQueueCapacity(25);//线程池所使用的缓冲队列
        taskExecutor.initialize();
        return taskExecutor;//返回基于线程池TaskExecutor
    }

    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return null;
    }

}