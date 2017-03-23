package git.zxxxd.servlet;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {

    private String name="Hello World";

    public HelloServlet(){

    }

    public HelloServlet(String name) {
        this.name = name;
    }

    public  void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("<h1>"+name+"</h1>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
