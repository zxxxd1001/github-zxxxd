package com.git.zxxxd.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 对客户端的请求进行监听，一旦监听程序能够获得客户端请求，就可以对所有客户端请求进行统一处理。
 * ServletRequestListener接口类中定义的两个方法对客户端请求的创建和销毁进行监听；
 * ServletRequestAttrubuteListener接口类对请求中的属性添加、修改和删除进行监听。
 */
public class MyServletRequestListener implements ServletRequestListener  {
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestDestroyed 一个http请求接入");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("requestInitialized http请求结束");
    }

//    @Override
//    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
//        System.out.println("attributeAdded："+servletRequestAttributeEvent.getName()+" , "+servletRequestAttributeEvent.getValue());
//    }
//
//    @Override
//    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
//        System.out.println("attributeRemoved："+servletRequestAttributeEvent.getName()+" , "+servletRequestAttributeEvent.getValue());
//    }
//
//    @Override
//    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
//        System.out.println("attributeReplaced："+servletRequestAttributeEvent.getName()+" , "+servletRequestAttributeEvent.getValue());
//    }
}
