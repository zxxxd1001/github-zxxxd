package test.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zhangxuedong on 2017/8/29.
 */
public class TestReadWriteLock {

    //不公平策略
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    //公平策略
//    static {
//        reentrantReadWriteLock = new ReentrantReadWriteLock(true);
//    }
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

    private static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了读锁，正在读取");
            Thread.sleep(1000);
            System.out.println("over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了写锁，正在写入");
            Thread.sleep(1000);
            System.out.println("over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(() -> read(), "Thread1").start();
        new Thread(() -> read(), "Thread2").start();
        new Thread(() -> write(), "Thread3").start();
        new Thread(() -> write(), "Thread4").start();

//        new Thread(()->write(),"Thread1").start();
//        new Thread(()->read(),"Thread2").start();
//        new Thread(()->read(),"Thread3").start();
//        new Thread(()->write(),"Thread4").start();
//        new Thread(()->read(),"Thread5").start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Thread thread[] = new Thread[100];
//                for (int i = 0; i < 100; i++) {
//                    thread[i] = new Thread(() -> read(), "子线程创建的Thread" + i);
//                }
//                for (int i = 0; i < 100; i++) {
//                    thread[i].start();
//                }
//            }
//        }).start();


//        System.out.println("先演示降级是可以的，写锁可以变为读锁");
//        Thread thread1 = new Thread(() -> writeDowngrading(), "Thread1");
//        thread1.start();
//        System.out.println("------------------");
//        System.out.println("演示升级是不行的，读锁不可以变为写锁");
//        Thread thread2 = new Thread(() -> readUpgrading(), "Thread2");
//        thread2.start();
    }

    private static void readUpgrading() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了读锁，正在读取");
            Thread.sleep(1000);
            System.out.println("升级会带来阻塞");
            writeLock.lock();
            System.out.println(Thread.currentThread().getName() + "获取到了写锁，升级成功");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + "释放读锁");
            readLock.unlock();
        }
    }

    private static void writeDowngrading() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "得到了写锁，正在写入");
            Thread.sleep(1000);
            readLock.lock();
            System.out.println("在不释放写锁的情况下，直接获取读锁，成功降级");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放写锁");
            writeLock.unlock();
        }
    }
}
