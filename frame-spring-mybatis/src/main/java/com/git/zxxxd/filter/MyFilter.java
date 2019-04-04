package com.git.zxxxd.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String parameterName=initParameterNames.nextElement();
            System.out.println("参数名： "+parameterName);
            System.out.println("参数值： "+filterConfig.getInitParameter(parameterName));
            System.out.println();
        }
        //server启动初始化方法
        System.out.println("init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //过滤请求
        System.out.println("doFilter");
        String str=((HttpServletRequest) servletRequest).getServletPath();
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        //server关闭执行
        System.out.println("destroy");
    }
}
