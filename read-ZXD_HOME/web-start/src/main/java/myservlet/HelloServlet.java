package myservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangxuedong on 2017/3/8.
 */
public class HelloServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String msg = "Hello World!";


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>" + msg + "</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
    }
}
