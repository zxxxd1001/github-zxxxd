package com.git.zxxxd.listener;

import javax.servlet.*;

/**
 * ServletContextListener监听ServletContext对象
 * ServletContextAttributeListener监听对ServletContext属性的操作，比如增加、删除、修改
 */
public class MyServletContextListener implements ServletContextListener{
    private ServletContext servletContext=null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext=servletContextEvent.getServletContext();//初始化一个ServletContext对象
        System.out.println("获取web.xml<context-param>配置参数："+servletContext.getInitParameter("contextParam"));
        System.out.println("用来初始化ServletContext对象。");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContext=null;//用于释放ServletContext对象
        System.out.println("用于释放ServletContext对象。");
    }
}
