package server.bind;

import com.git.zxxxd.server.bind.AppModule;
import com.git.zxxxd.server.bind.MyThread;
import com.git.zxxxd.server.bind.Sex;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Provider;
import org.junit.Before;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AppTest {
    @Inject private String s;
    @Inject private Runnable r;
    @Inject private Long SessionId;
    @Inject private Provider<List> list;
    @Inject private Provider<List<String>> list1;
    @Inject @Named("sex") private String sex;
    @Inject @Sex private String sex1;
    @Inject @Named("list") private List<String> listStr;
    @Inject private Set<String> set;
    @Inject private Map<String,String> map;

    @Before
    public void setUp(){
        Guice.createInjector(new AppModule(), new AbstractModule() {
            @Override
            protected void configure() {
                bind(MyThread.class).toInstance(new MyThread(){
                    public void run() {
                        System.out.println("连接绑定");
                    }
                });
            }
        }).injectMembers(this);
    }
    @Test
    public void test(){
        System.out.println(s);
        r.run();
        System.out.println(SessionId);
        System.out.println(list.get().toString());
        System.out.println(list1.get().toString());
        System.out.println(sex);
        System.out.println(sex1);
        System.out.println(listStr.toString());
        System.out.println(set.toString());
        System.out.println(map);
    }
}
