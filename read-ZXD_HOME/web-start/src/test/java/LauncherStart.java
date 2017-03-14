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
    public static void main(String[] args) {
        try {
            Server server = new Server(8080);
            ResourceHandler resourceHandler = new ResourceHandler();
            resourceHandler.setResourceBase("./");
            resourceHandler.setDirectoriesListed(true);
            server.setHandler(resourceHandler);

            ServletContextHandler servletContextHandler=new ServletContextHandler(ServletContextHandler.SESSIONS);
            servletContextHandler.addServlet(new ServletHolder(new MyClientServlet()),"/my-client");
            server.setHandler(servletContextHandler);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
