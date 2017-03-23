package git.zxxxd.start;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 *
 * web.setResourceBase这句话比较重要，设置了你的那些JSP页面到哪里去找。比如此次我的JSP就是放在WEB-INF的下面。
 */
public class OneWebApp {
    public static void main(String[] args) {
        String jetty_home =System.getProperty("jetty.home","..");
        System.out.println(jetty_home);
        Server server=new Server(8080);
        ServerConnector serverConnector=new ServerConnector(server);

        WebAppContext web=new WebAppContext();
        web.setDescriptor("WEB-INF/web.xml");
        web.setContextPath("/");
        web.setResourceBase("./src/main/webapp");
        web.setClassLoader(Thread.currentThread().getContextClassLoader());
        web.setParentLoaderPriority(true);
        server.setHandler(web);

        try {
            server.join();
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
