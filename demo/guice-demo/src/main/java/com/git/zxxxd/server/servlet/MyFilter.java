package com.git.zxxxd.server.servlet;


import com.google.inject.Singleton;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Singleton
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest h=(HttpServletRequest)request;
        if(h.getPathInfo().contains("myFilter")){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().append("MyFilter");
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
