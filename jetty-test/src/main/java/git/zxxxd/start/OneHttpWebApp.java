package git.zxxxd.start;

import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by zhangxuedong on 2017/3/24.
 */
public class OneHttpWebApp {
    public static void main(String[] args) {
        Server server=new Server(8080);
        HttpConfiguration https_config = new HttpConfiguration();
        https_config.setSecureScheme("https");
        https_config.setSecurePort(8079);
        https_config.setOutputBufferSize(32768);
        https_config.addCustomizer(new SecureRequestCustomizer());

        SslContextFactory sslContextFactory=new SslContextFactory();
        sslContextFactory.setKeyStorePath("src/jnpl/zxxd.keystore");
        sslContextFactory.setKeyStorePassword("manager");
        sslContextFactory.setKeyManagerPassword("manager");
        ServerConnector serverConnector=
                new ServerConnector(server,
                        new SslConnectionFactory(sslContextFactory, "http/1.1"));
        //serverConnector.setPort(8079);
//        serverConnector.setStopTimeout(50000);
//        serverConnector.setIdleTimeout(500000);
        server.addConnector(serverConnector);

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
