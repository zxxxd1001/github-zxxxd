package git.zxxxd.start;

import git.zxxxd.servlet.HelloHandler;
import git.zxxxd.servlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

/**
 * Created by zhangxuedong on 2017/3/22.
 */
public class OneContext {
    public static void main(String[] args) {
        Server server=new Server(8080);
        ContextHandler contextHandler=new ContextHandler();
        contextHandler.setContextPath("/hello");
        contextHandler.setResourceBase(".");
        contextHandler.setClassLoader(Thread.currentThread().getContextClassLoader());
        server.setHandler(contextHandler);
        contextHandler.setHandler(new HelloHandler());

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
