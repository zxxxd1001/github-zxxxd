package test.lock;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock {
    private static ReentrantLock lock =  new ReentrantLock();

    private static void getHoldCount(){
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.lock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    private static void bookSeat() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始预定座位");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "完成预定座位");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    private static void accessResource() {
        lock.lock();
        try {
            System.out.println("已经对资源进行了处理");
            if (lock.getHoldCount()<5) {
                System.out.println(lock.getHoldCount());
                accessResource();
                System.out.println(lock.getHoldCount());
            }
        } finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
//        getHoldCount();

//        new Thread(() -> bookSeat(),"t-01").start();
//        new Thread(() -> bookSeat(),"t-02").start();
//        new Thread(() -> bookSeat(),"t-03").start();
//        new Thread(() -> bookSeat(),"t-04").start();

//        accessResource();

    }
}
