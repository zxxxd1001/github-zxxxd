package test.callableFutureExecutor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolShutDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ShutDownTask());
        }
        Thread.sleep(1500);
//        返回 未开始执行的任务列表 立刻停止线程与线程池不在接收新的任务
//        List<Runnable> runnableList = executorService.shutdownNow();

//        停止线程池 不接受新任务。
//        executorService.shutdown();
//        executorService.execute(new ShutDownTask());
        /**
         * 当前线程阻塞，直到
         * 1。等所有已提交的任务（包括正在跑的和队列中等待的）执行完
         * 2。或者等超时时间到
         * 3。或者线程被中断，抛出InterruptedException
         */
        boolean b = executorService.awaitTermination(7L, TimeUnit.SECONDS);
        System.out.println("awaitTermination："+b);
        System.out.println("isShutdown："+executorService.isShutdown());
        executorService.shutdown();
        System.out.println("isShutdown："+executorService.isShutdown());
        System.out.println("isTerminated："+executorService.isTerminated());//如果关闭后所有任务都已完成，则返回
        Thread.sleep(10000);
        System.out.println("isTerminated："+executorService.isTerminated());//如果关闭后所有任务都已完成，则返回
    }
}

class ShutDownTask implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(50);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断了");
        }
    }
}
