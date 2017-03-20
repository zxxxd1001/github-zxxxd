package jettydemo;

import myservlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

public class EmbeddedJettyServer{
    public static void main(String[] args) {
        try {
            System.out.println(ServletContextHandler.SESSIONS);
            Server server=new EmbeddedJettyServer().start();
            server.start();
            server.join();
        } catch (Exception e) {
            System.out.println("catch块！");
            e.printStackTrace();
        }
    }

    private Server start() throws Exception{
        System.out.println(this.getClass().getClassLoader().getResource("webapp"));
       //System.out.println(this.getClass().getResource("/").toURI().toASCIIString());
        Server server = new Server(8080);
        WebAppContext web=new WebAppContext();
        web.setContextPath("/");
        web.setResourceBase("./");
        web.setWelcomeFiles(new String[]{"login.html"});
        web.setDistributable(true);

        web.addServlet(new ServletHolder(new HelloServlet()),"/hello");
        server.setHandler(web);
        return server;
    }
}