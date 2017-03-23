package git.zxxxd.start;

import git.zxxxd.servlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by zhangxuedong on 2017/3/22.
 */
public class OneServletContext {
    public static void main(String[] args) {
        Server server=new Server(8080);
        ServletContextHandler servlet=new ServletContextHandler(ServletContextHandler.SESSIONS);
        servlet.setContextPath("/");
        servlet.addServlet(new ServletHolder(new HelloServlet()),"/*");
        servlet.addServlet(new ServletHolder(new HelloServlet("欢迎")),"/login");
        servlet.addServlet(new ServletHolder(new HelloServlet("再见")),"/logout");

        server.setHandler(servlet);

        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
