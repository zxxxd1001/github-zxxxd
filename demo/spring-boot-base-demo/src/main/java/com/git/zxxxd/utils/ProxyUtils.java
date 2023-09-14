package com.git.zxxxd.utils;

import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtils {

    public static Object createTimingProxy(final Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long startTime = System.currentTimeMillis();
                        Object result = method.invoke(target, args);
                        long endTime = System.currentTimeMillis();

                        System.out.println("Method " + method.getName() + " took " + (endTime - startTime) + "ms");

                        return result;
                    }
                });
    }

    public static Object web(Object target){
        Class<?> beanClass = target.getClass();
        if (beanClass.isAnnotationPresent(RestController.class)) {
            return Proxy.newProxyInstance(
                    beanClass.getClassLoader(),
                    beanClass.getInterfaces(),
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            long startTime = System.currentTimeMillis();
                            Object result = method.invoke(target, args);
                            long endTime = System.currentTimeMillis();

                            System.out.println("Method " + method.getName() + " took " + (endTime - startTime) + "ms");

                            return result;
                        }
                    });
        }
        return target;
    }
}
