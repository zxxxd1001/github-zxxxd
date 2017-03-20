import myservlet.MyClientServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import javax.servlet.annotation.WebServlet;

/**
 * Created by zhangxuedong on 2017/3/6.
 */
public class LauncherStart {
    /**
     * 这个Demo阐述了jetty与servlet之间的事情，
     * 他们之间的连接就是servletContextHandler，
     * 这是handlerWrapper的一个子类，
     * 这个在jetty的嵌入式使用(1)中已经阐述过了。
     servletContextHandler添加servlet采用的是addServlet的方式，里面需要实例ServletHolder（这里为HelloHandler）以及访问的路径，可以添加多个servlet进行处理
     * @param args
     */
    public static void main(String[] args) {
        try {
            Server server = new Server(8080);
            System.out.println(ServletContextHandler.SESSIONS);
            ServletContextHandler servletContextHandler=new ServletContextHandler(ServletContextHandler.SESSIONS);
            servletContextHandler.setContextPath("/");
            servletContextHandler.addServlet(new ServletHolder(new MyClientServlet()),"/my-client");
            servletContextHandler.setResourceBase("./");
            servletContextHandler.setWelcomeFiles(new String[]{"index.html"});
            server.setHandler(servletContextHandler);
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
