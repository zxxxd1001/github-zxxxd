package server.module;

import com.git.zxxxd.server.bind.AppModule;
import com.git.zxxxd.server.module.MainModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.util.Modules;
import org.junit.Before;
import org.junit.Test;

public class ModuleTest {
    @Inject
    private String s;
    @Inject
    private Long l;

    @Before
    public void setUp(){
        Guice.createInjector(Modules.override(new AppModule()).with(new MainModule())).injectMembers(this);
    }
    @Test
    public void test(){
        System.out.println(s);
        System.out.println(l);
    }
}
