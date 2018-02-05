package server.inject;

import com.git.zxxxd.server.Inject.AppModule;
import com.git.zxxxd.server.Inject.impl.NamesOrAnnotationInject;
import com.git.zxxxd.server.Inject.impl.ProviderInject;
import com.git.zxxxd.server.Inject.impl.SessionManager;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

public class TestSessionManager {
    @Inject
    private SessionManager sessionManager;
    @Inject
    private ProviderInject providerInject;

    @Inject
    private NamesOrAnnotationInject namesInject;

    @Before
    public void setUp() throws Exception {
        Guice.createInjector(new AppModule()).injectMembers(this);
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("注入Guice值不变");
        System.out.println(sessionManager.getSessionId());
        Thread.sleep(1000);
        System.out.println(sessionManager.getSessionId());

        System.out.println("--Provider绑定是在须要时才问Guice拿的");
        System.out.println(providerInject.getSessionId());
        Thread.sleep(1000);
        System.out.println(providerInject.getSessionId());

        System.out.println("--Names与Annotation注入");
        System.out.println("sessionId: "+namesInject.getSessionId());
        System.out.println("age: "+namesInject.getAge());
    }
}
