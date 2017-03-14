package jettydemo;

import myservlet.HelloServlet;
import myservlet.MyClientServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by zhangxuedong on 2017/3/7.
 */
public class JettyDemo01 {
    public static void main(String[] args) throws Exception{
        /**
         * 运行Java程序，Jetty服务器启动。
         * 此时在浏览器中访问http://localhost:8080就可以浏览D:/test文件夹中的html页面或者其他文件。
         * 但是只能访问静态页面，程序无法支持Servlet/JSP。
         * 如果想要显示文件夹中的所有文件的列表，可以设置： resourceHandler.setDirectoriesListed(true);
         */
        Server server = new Server(8080);

//        ResourceHandler resourceHandler = new ResourceHandler();
        // 设置Web内容上下文路径
//        resourceHandler.setResourceBase("./");
//
//        //如果想要显示文件夹中的所有文件的列表，可以设置：
//        resourceHandler.setDirectoriesListed(true);
//
//        server.setHandler(resourceHandler);


//        WebAppContext web=new WebAppContext();
//        web.setResourceBase("./");
//
//        server.setHandler(web);

        ServletContextHandler servletContextHandler=new ServletContextHandler(ServletContextHandler.SESSIONS);
        // 设置上下文路径
        servletContextHandler.setContextPath("/");
        server.setHandler(servletContextHandler);
        servletContextHandler.addServlet(new ServletHolder(new HelloServlet()),"/hello");
        System.out.println();
        server.start();
    }
}
