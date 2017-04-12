package jdk8NewTest;

import jdk8New.TestInterface;
import jdk8New.TestInterfaceImpl;
import jdk8New.TestInterfaceImplTow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhangxuedong on 2017/4/11.
 */
public class JunitInterface {
    @Before
    public void before(){
        System.out.println("before");
    }
    @Test
    public void test(){
        TestInterface.testStatic();
        TestInterface t=new TestInterfaceImpl();
        t.testDefault();

        TestInterface tt=new TestInterfaceImplTow();
        tt.testDefault();
    }
    @After
    public void After(){
        System.out.println("after");
    }
}
