package aop.test;

import org.springframework.stereotype.Component;

@Component
public class ConfigAop {
    public void beforeMethod(){
        System.out.println("ConfigAop的beforeMethod");
    }

    public void afterMethod(){
        System.out.println("ConfigAop的afterMethod");
    }
    public void exceptionMethod(){
        System.out.println("ConfigAop的exceptionMethod");
    }
}
