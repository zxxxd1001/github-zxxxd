package server.servlet;

import com.git.zxxxd.server.servlet.AppModule;
import com.git.zxxxd.server.servlet.HelloServlet;
import com.git.zxxxd.server.servlet.MyGuiceServletContextListener;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceFilter;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.core.StandardService;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.eclipse.jetty.servlet.DefaultServlet;

import javax.servlet.ServletContext;

public class AppModuleTest {
    public static void main(String[] args) throws Exception {
        Injector injector=Guice.createInjector(new AppModule());
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8091);
        tomcat.init();
        StandardServer s=(StandardServer)tomcat.getServer();
        s.addLifecycleListener(new AprLifecycleListener());
        StandardContext ctx = (StandardContext) tomcat.addContext("/api", null);
//        FilterDef filterDef = new FilterDef();
//        filterDef.setFilterName("guice");
//        filterDef.setFilterClass(GuiceFilter.class.getName());
//        ctx.addFilterDef(filterDef);
//        FilterMap filterMap = new FilterMap();
//        filterMap.setFilterName("guice");
//        filterMap.addURLPattern("/*");
//        ctx.addFilterMap(filterMap);
//        ctx.addApplicationEventListener(new MyGuiceServletContextListener());
        tomcat.addServlet("/api","hello",new HelloServlet());
        ctx.addServletMappingDecoded("/hello","hello");
        tomcat.start();
        tomcat.getServer().await();
    }
}
