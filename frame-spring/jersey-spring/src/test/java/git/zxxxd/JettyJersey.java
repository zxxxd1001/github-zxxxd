package git.zxxxd;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class JettyJersey {
    public static void main(String[] args) {
        Server server=new Server(8002);
        ServletHolder servlet = new ServletHolder(new SpringServlet());
        servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
        servlet.setInitParameter("com.sun.jersey.config.property.packages", "git.zxxxd.resource");
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.setContextPath("/");
        handler.addServlet(servlet, "/*");
        handler.addEventListener(new ContextLoaderListener());
        handler.addEventListener(new RequestContextListener());
        handler.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        handler.setInitParameter("contextConfigLocation", SpringAppModule.class.getName());
        server.setHandler(handler);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("start...in 8002");
    }
//
//    Server server=new Server(8002);
//    ServletHolder servlet = new ServletHolder(new ServletContainer(MyRestWebService.class));
//    //        servlet.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
////        servlet.setInitParameter("com.sun.jersey.config.property.packages", "git.zxxxd.resource");
//    ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        handler.setContextPath("/");
//        handler.addServlet(servlet, "/*");
//        handler.addEventListener(new ContextLoaderListener());
////        handler.addEventListener(new RequestContextListener());
//        handler.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
//        handler.setInitParameter("contextConfigLocation", SpringAppModule.class.getName());
//        server.setHandler(handler);
//        try {
//        server.start();
//    } catch (Exception e) {
//        e.printStackTrace();
//    }
//        System.out.println("start...in 8002");
}
