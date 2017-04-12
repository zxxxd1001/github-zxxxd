package jdk8New;

/**
 * Created by zhangxuedong on 2017/4/11.
 */
public class TestInterfaceImplTow implements TestInterface{

    @Override
    public void test() {

    }

    public void testDefault(){
        System.out.println("TestInterfaceImplTow重写的testDefault方法");
    }
}
