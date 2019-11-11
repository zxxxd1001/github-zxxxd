package newJava8.lambda;

import java.util.Optional;

public class TestOptionad {
    public static void main(String[] args) {
        TestOptionad t = new TestOptionad();
        t.test();
    }

    public void test() {
        Optional<Person> presonList = Optional.empty();
//        Person p=presonList.get();//值为 null 的时候抛出异常。 要避免异常,NoSuchElementException: No value present
//        presonList=Optional.of(null);//方法会抛出 NullPointerException：
        presonList = Optional.ofNullable(null);
        System.out.println("value不等于null：" + presonList.isPresent());
        //=================返回默认值Start
        Person pp = null;
        Person p = new Person("张三", 18);
        Person ppp = Optional.ofNullable(pp).orElse(p);//如果有值则返回该值，否则返回传递给它的参数值
        System.out.println("返回默认值：" + ppp.getAge());

        Person person = Optional.ofNullable(pp).orElseGet(() -> p);
        System.out.println("返回默认值：" + person.getAge());
        //=================返回默认值end

        //=================返回异常Start
        person = Optional.ofNullable(p).orElseThrow(() -> new IllegalArgumentException());
        System.out.println("返回异常：" + person.getAge());
//        Optional.ofNullable(pp).orElseThrow(() -> new IllegalArgumentException());
        //=================返回异常end
        //=================过滤值start
        Optional optional=Optional.ofNullable(p).filter(item ->item.getName()=="李四");
        System.out.println(optional);
        //=================过滤值end


    }

    private class Person {
        private String name;
        private int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
