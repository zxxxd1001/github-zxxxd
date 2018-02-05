package server.inject;

import com.git.zxxxd.server.Inject.AppModule;
import com.git.zxxxd.server.Inject.OrderService;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.Test;

public class ServerTest {
    @Inject
    private OrderService o;
    @Before
    public void setUp(){
        Guice.createInjector(new AppModule()).injectMembers(this);
    }
    @Test
    public void test(){
        o.sendToPayment(123L);
    }
}
