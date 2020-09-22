package test.callableFutureExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) throws Exception {
        ThreadPool tp=new ThreadPool();
        tp.cachedThreadPool();
        Thread.sleep(2000);
        System.out.println("===================");
        tp.singleThreadExecutor();
        Thread.sleep(2000);
        System.out.println("===================");
        tp.fixedThreadPoolTest();
        Thread.sleep(2000);
        System.out.println("===================");
        tp.scheduledThreadPoolTest();
    }
    private void cachedThreadPool(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task());
        }
    }
    private void singleThreadExecutor(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task());
        }
    }
    private void fixedThreadPoolTest(){
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Task());
        }
    }

    private void scheduledThreadPoolTest() throws Exception{
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(10);
//        threadPool.schedule(new Task(), 5, TimeUnit.SECONDS);
        threadPool.scheduleAtFixedRate(new Task(), 1, 3, TimeUnit.SECONDS);

        Thread.sleep(3000);

        threadPool.shutdown();
        threadPool.execute(new Task());
    }
}
class Task implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
