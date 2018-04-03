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
