package first;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.startup.Tomcat.FixContextListener;
import org.apache.coyote.http11.Http11NioProtocol;

public class EmbeddedTomcat {

//    http://127.0.0.1:9080/book/home
//    https://127.0.0.1:9090/book/home
    public static void main(String[] args) throws Exception {
        EmbeddedTomcat t=new EmbeddedTomcat();
//        t.http();
//        t.https();
    }
    public void http() throws Exception{
        final int port = 9080;
        final String docBase = "e:/tmp/tomcat";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setBaseDir(docBase);
        tomcat.getHost().setAutoDeploy(false);

        String contextPath = "/book";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "homeServlet",new HomeServlet());
        context.addServletMappingDecoded("/home", "homeServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
    public void https() throws Exception{
        final String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";
        final String docBase = "e:/tmp/tomcat";
        final int port = 9080;
        final int ports = 9090;
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.setBaseDir(docBase);

        Connector connector = new Connector(DEFAULT_PROTOCOL);
        connector.setPort(ports);

        Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
        protocol.setKeystorePass("123456");
        protocol.setKeystoreFile("e:/tmp/ssl/boot.keystore");
        protocol.setKeyAlias("mykey");
        protocol.setSSLEnabled(true);

        tomcat.getService().addConnector(connector);
        tomcat.getHost().setAutoDeploy(false);

        String contextPath = "/book";
        StandardContext context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new FixContextListener());
        tomcat.getHost().addChild(context);

        tomcat.addServlet(contextPath, "homeServlet", new HomeServlet());
        context.addServletMappingDecoded("/home", "homeServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}