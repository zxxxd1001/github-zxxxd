package jdk8New;

/**
 * Created by zhangxuedong on 2017/4/11.
 */
public interface TestMultipleInterface {
    static void testStatic(){
        System.out.println("TestMultipleInterface接口的静态方法");
    }

    default void testDefault(){
        System.out.println("接口的默认方法");
    }
}
