package git.zxxxd.spring.aop;

import git.zxxxd.spring.aop.annotation.OnException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class AnnotationAop {
    /**
     * execution 在方法执行时触发
     */

    @Pointcut("within(git.zxxxd.spring.aop..*)")
//    @Pointcut("execution(* git.zxxxd.spring.aop.dao..*(..))")
    private void anyMethod(){

    }

    @Pointcut("@annotation(git.zxxxd.spring.aop.annotation.AopAnntation)")
    private void anyAnntation(){}
    @Pointcut("@annotation(git.zxxxd.spring.aop.annotation.OnException)")
    private void anyOnException(){}

    @Before("anyMethod()")
    public void doBefore(){
        System.out.println("前置通知");
    }

    @AfterReturning(value = "anyMethod()",returning = "o")
    public void doAfter(Object o){
        System.out.println("后置通知 返回值："+o);
    }

    @After("anyMethod()")
    public void after(JoinPoint joinPoint){
        System.out.println("最终通知 the name:"+joinPoint.getSignature().getName());
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        System.out.println("例外通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }

    @Before("anyAnntation()")
    public void doAnntation(){
        System.out.println("aop注解拦截Before");
    }

    @AfterReturning(value = "anyAnntation()",returning = "o")
    public void doAfterReturning(Object o){
        System.out.println(o);
        System.out.println("aop注解拦截AfterReturning");
    }
    @AfterThrowing(value = "anyOnException()",throwing = "e")
    public void doAfterThrowing(NullPointerException e){
        System.out.println("AfterThrowing注解拦截 空指针异常");
    }
    @AfterThrowing(value = "anyOnException()",throwing = "e")
    public void doAfterThrowing(JoinPoint jp,Exception e){
        String s="";
        try {
            String methodName = jp.getSignature().getName();
            Class<?> targetClass = jp.getTarget().getClass();
            Class[] parameterTypes = ((MethodSignature) jp.getSignature()).getParameterTypes();
            Method methodClass = targetClass.getMethod(methodName,parameterTypes);
            Annotation[] annotations = methodClass.getAnnotations();
            for(Annotation annotation:annotations){
                if (annotation instanceof OnException) {
                    s=((OnException) annotation).value();
//                    throw new Exception(s, e);
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println("AfterThrowing注解拦截 Exception ：" +s );
    }
}
