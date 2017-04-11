package git.zxxxd;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import git.zxxxd.module.InvalidRequestServlet;
import git.zxxxd.module.ResourceModule;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * Created by zhangxuedong on 2017/4/9.
 */
public class LauncherStart {
    public static void main(String[] args) throws Exception{
        Injector injector = Guice.createInjector(new AbstractModule() {
            @Override
            protected void configure() {
                install(new ResourceModule());
            }
        });

        Server server = new Server(8091);

        ServletContextHandler servletHandler = new ServletContextHandler();
        servletHandler.setContextPath("/");
        servletHandler.addServlet(new ServletHolder(new InvalidRequestServlet()), "/*");
        FilterHolder guiceFilter = new FilterHolder(injector.getInstance(GuiceFilter.class));
        servletHandler.addFilter(guiceFilter, "/*", EnumSet.allOf(DispatcherType.class));

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{servletHandler, new DefaultHandler()});

        server.setHandler(handlers);
        server.start();
        server.join();
    }
}
