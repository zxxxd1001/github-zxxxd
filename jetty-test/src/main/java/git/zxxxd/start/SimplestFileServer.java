package git.zxxxd.start;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;

public class SimplestFileServer {
    public static void main(String[] args) {
        Server server=new Server();
        HttpConfiguration config = new HttpConfiguration();
        ServerConnector connector = new ServerConnector(server,new HttpConnectionFactory(config));
        connector.setPort(8080);
        server.addConnector(connector);

//        文件服务器
        ResourceHandler resourceHandler=new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setWelcomeFiles(new String[]{"index.html"});
        resourceHandler.setResourceBase("./src/main/webapp");

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

