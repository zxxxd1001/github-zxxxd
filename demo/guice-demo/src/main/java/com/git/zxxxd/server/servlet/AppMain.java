package com.git.zxxxd.server.servlet;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.DispatcherType;
import java.io.File;
import java.util.EnumSet;

public class AppMain {
    public static void main(String[] args) {
//        Injector injector=Guice.createInjector(new AppModule());

        Server server = new Server(8090);//设置端口
        ServletContextHandler servletHandler = new ServletContextHandler();
        servletHandler.setContextPath("/api");

        servletHandler.addServlet(new ServletHolder(new ErrorServlet()),"/*");
        //启动Guice
//        FilterHolder guiceFilter = new FilterHolder(injector.getInstance(GuiceFilter.class));
        FilterHolder guiceFilter = new FilterHolder(GuiceFilter.class);
        servletHandler.addFilter(guiceFilter, "/*", EnumSet.allOf(DispatcherType.class));
        //
        servletHandler.addEventListener(new MyGuiceServletContextListener());

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});//设置主页页面

        String webappDirLocation = "src/main/webapp/";//设置文件位置
        String absolutePath = new File(webappDirLocation).getAbsolutePath();
        resourceHandler.setResourceBase(absolutePath);

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, servletHandler, new DefaultHandler()});

        server.setHandler(handlers);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
