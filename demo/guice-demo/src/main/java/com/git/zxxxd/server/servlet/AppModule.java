package com.git.zxxxd.server.servlet;

import com.google.inject.servlet.ServletModule;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AppModule extends ServletModule {
    protected void configureServlets() {
        serve("/hello","/h").with(HelloServlet.class);
        filter("/*").through(MyFilter.class);
        filter("/*").through(helloFilter());
    }

    private Filter helloFilter(){
        return  new Filter() {
            @Override
            public void init(FilterConfig filterConfig) throws ServletException {

            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                HttpServletRequest h=(HttpServletRequest)request;
                if(h.getPathInfo().contains("helloFilter")){
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().append("HelloFilter");
                }
                chain.doFilter(request,response);
            }

            @Override
            public void destroy() {

            }
        };
    }

}
