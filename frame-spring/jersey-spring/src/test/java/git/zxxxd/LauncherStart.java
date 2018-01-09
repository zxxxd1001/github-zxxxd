package git.zxxxd;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by zhangxuedong on 2017/4/27.
 */
public class LauncherStart {
    public static void main(String[] args) {
        ServletContainer s=new ServletContainer(MyRestWebService.class);
        System.out.println(s);
        Server server=new Server();
        WebAppContext web=new WebAppContext();
        ServerConnector serverConnector=new ServerConnector(server);
        System.out.println(server.getVersion());
    }
}
