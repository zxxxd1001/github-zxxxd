package git.zxxxd.spring.mvc;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class ReadXml {
    public static void main(String[] args) throws Exception {
        Server server=new Server(8001);
        WebAppContext web=new WebAppContext();
        web.setDescriptor("WEB-INF/web.xml");
        web.setContextPath("/");
//        web.setResourceBase(Class.class.getResource("/").getPath());
        web.setResourceBase("./src/main/webapp");
        web.setClassLoader(Thread.currentThread().getContextClassLoader());
        web.setParentLoaderPriority(true);
        server.setHandler(web);

        server.start();
        server.join();
    }
}
