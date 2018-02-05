package com.git.zxxxd.server.servlet;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class HelloServlet extends HttpServlet{

    private TestInjector testInjector;
    @Inject
    public HelloServlet(TestInjector testInjector) {
        this.testInjector = testInjector;
    }
    public HelloServlet() {
    }

    public void init() throws ServletException {
        System.out.println("init execute ...");
        System.out.println("init end ...");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("hello servlet!");
        testInjector.test();
    }
}
