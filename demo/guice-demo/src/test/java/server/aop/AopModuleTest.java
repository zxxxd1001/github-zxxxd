package server.aop;

import com.git.zxxxd.server.aop.AopModule;
import com.git.zxxxd.server.aop.Hello;
import com.git.zxxxd.server.aop.LogInterceptor;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

public class AopModuleTest {
    @Inject
    private Hello hello;

    @Before
    public void setUp(){
        Guice.createInjector(new AopModule()).injectMembers(this);
    }
    @Test
    public void test(){
        hello.print("123");
        hello.add("456",new LogInterceptor());
    }
}
