package jettydemo;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;

/**
 * Created by zhangxuedong on 2017/3/16.
 */
public class JettyDemoOne {
    public static void main(String[] args) {
        try {
            Server server = new Server(8080);
//SelectChannelConnector connector = new SelectChannelConnector();
            //connector.setPort(8080);
//server.addConnector(connector);
            ResourceHandler handler = new ResourceHandler();  //静态资源处理的handler
            handler.setDirectoriesListed(true);  //会显示一个列表
            //handler.setWelcomeFiles(new String[]{"index.html"});
            handler.setResourceBase("./web-start/src/main/webapp/base");
            server.setHandler(handler);


            server.start();
            server.join();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
