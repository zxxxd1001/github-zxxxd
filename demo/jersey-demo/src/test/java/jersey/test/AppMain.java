package jersey.test;

import git.zxxxd.MyResourceConfig;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;


public class AppMain {
    public static void main(String[] args) {
        Server server = new Server(8090);//设置端口
        ServletContextHandler servletHandler = new ServletContextHandler();
        servletHandler.setContextPath("/api");
        ServletContainer servletContainer = new ServletContainer(new MyResourceConfig("git.zxxxd.resource"));
        servletHandler.addServlet(new ServletHolder(servletContainer),"/*");

        server.setHandler(servletHandler);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
