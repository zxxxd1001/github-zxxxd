package com.git.zxxxd.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SomeServlet extends HttpServlet {
    public void doGet(HttpServletRequest
                              request, HttpServletResponse
                              response) throws ServletException,
            IOException {
        //读取请求参数值
//        String qty = request.getParameter("qty");
        /*
         * 通常需要对请求参数值做一些检查，
         * 比如，检查qty是不是一个合法的数字。
         */
        //处理
        String greeting = "";
//        for (int i = 0; i < Integer.parseInt(qty); i++) {
            greeting += "<h1>hello Kitty</h1>";
//        }
        //设置服务器返回的数据类型
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(greeting);
        out.close();

    }
}
