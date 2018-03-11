package git.zxxxd.spring.mvc;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.servlet.DispatcherServlet;

public class TestMVC {

    public static void main(String[] args) throws Exception {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setContextConfigLocation("classpath:applicationContextMVC.xml");
        ServletHolder servletHolder=new ServletHolder(dispatcherServlet);
        servletHolder.getRegistration().setLoadOnStartup(1);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(servletHolder, "/api/*");

        HandlerList list=new HandlerList();
        list.setHandlers(new Handler[]{context,new DefaultHandler()});

        Server server = new Server(8001);
        server.setHandler(list);
        server.start();
        server.join();
    }
}
