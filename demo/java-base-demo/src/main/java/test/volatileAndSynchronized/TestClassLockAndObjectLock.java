package test.volatileAndSynchronized;

public class TestClassLockAndObjectLock {
    public static void main(String[] args) {
        Task task=new Task();
        new Thread(new Runnable() {
            @Override
            public void run() {
                task.doLongTimeTaskA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                task.doLongTimeTaskB();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                task.doLongTimeTaskC();
            }
        }).start();
    }
}
class Task{
    public synchronized static void doLongTimeTaskA() {
        System.out.println("name = doLongTimeTaskA, " + Thread.currentThread().getName() + ", begain");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("name = doLongTimeTaskA, " + Thread.currentThread().getName() + ", end");
    }

    public synchronized static void doLongTimeTaskB() {
        System.out.println("name = doLongTimeTaskB, " + Thread.currentThread().getName() + ", begain");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("name = doLongTimeTaskB, " + Thread.currentThread().getName() + ", end");
    }

    public synchronized void doLongTimeTaskC() {

        System.out.println("name = doLongTimeTaskC, " + Thread.currentThread().getName() + ", begain");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("name = doLongTimeTaskC, " + Thread.currentThread().getName() + ", end");

    }
}