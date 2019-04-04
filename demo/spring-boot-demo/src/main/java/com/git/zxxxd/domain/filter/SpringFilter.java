package com.git.zxxxd.domain.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns="/*",filterName="SpringFilter")
public class SpringFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
