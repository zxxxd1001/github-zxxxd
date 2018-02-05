package com.git.zxxxd.server.aop;

import com.google.common.base.Joiner;
import com.google.inject.Provider;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import javax.inject.Inject;

public class LogInterceptor implements MethodInterceptor {
    @Inject
    private Provider<Long> l;
    @Inject
    private Long c;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("通过aop记录日志");
        System.out.println("Provider<Long>: "+l.get()+" Long: "+c);
        System.out.println(invocation.getThis());
        System.out.println(invocation.getMethod());
        System.out.println(invocation.getArguments().length+" "+ Joiner.on(",").join(invocation.getArguments()));
        System.out.println(invocation.getStaticPart());
        return invocation.proceed();
    }

    @Override
    public String toString() {
        return "测试aop获取参数而重写的toString";
    }
}
