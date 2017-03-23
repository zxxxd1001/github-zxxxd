package git.zxxxd.start;

import git.zxxxd.servlet.HelloServlet;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.server.nio.NetworkTrafficSelectChannelConnector;

/**
 * Created by zhangxuedong on 2017/3/22.
 */
public class SimplestServer {
    public static void main(String[] args) {
        Server server=new Server();
        HttpConfiguration config = new HttpConfiguration();
        ServerConnector connector = new ServerConnector(server,new HttpConnectionFactory(config));
        connector.setPort(8080);

//        文件服务器
        ResourceHandler resourceHandler=new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("./src/test/java");

        HandlerList list=new HandlerList();
        list.setHandlers(new Handler[]{resourceHandler,new DefaultHandler()});

        server.setHandler(list);
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

