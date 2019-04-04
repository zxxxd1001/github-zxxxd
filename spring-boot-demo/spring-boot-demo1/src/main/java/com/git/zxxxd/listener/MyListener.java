package com.git.zxxxd.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextInitialized ..web应用启动");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextDestroyed ..web应用关闭");
    }
}
