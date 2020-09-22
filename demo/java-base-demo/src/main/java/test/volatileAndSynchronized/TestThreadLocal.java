package test.volatileAndSynchronized;

import java.util.Date;

public class TestThreadLocal {
    static  ThreadLocal<Test>  tl=new ThreadLocal();
    public void setTest(){
        tl.set(new Test(Thread.currentThread().getId(),Thread.currentThread().getName()));
    }
    public static void main(String[] args) {
        TestThreadLocal tt=new TestThreadLocal();
        tt.setTest();
        System.out.println(tl.get());

        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                tt.setTest();
                System.out.println(tl.get());
            }
        });
        t.start();

        new Service1().process();
    }
    class Test{
        private Long id;
        private String name;

        public Test(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "id=" + id +
                    ", name='" + name;
        }
    }
}


class Service1 {
    public void process() {
        User user = new User("超哥");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2拿到用户名：" + user.name);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名：" + user.name);
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
    String name;
    public User(String name) {
        this.name = name;
    }
}