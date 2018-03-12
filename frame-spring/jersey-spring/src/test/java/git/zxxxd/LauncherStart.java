package git.zxxxd;


import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class LauncherStart {
    public static void main(String[] args) throws Exception{

        ServletContainer jersey=new ServletContainer(MyRestWebService.class);
        ServletHolder sh=new ServletHolder(jersey);
        sh.getRegistration().setLoadOnStartup(1);

        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(sh,"/api/*");
        context.addEventListener(new ContextLoaderListener());
//        context.addEventListener(new RequestContextListener());
//        context.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
//        context.setInitParameter("contextConfigLocation", SpringAppModule.class.getName());


        Server server=new Server(8001);
        server.setHandler(context);
        server.start();
        server.join();
    }
}
