package git.zxxxd.spring.aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class MatchingAop {
    @AopAnntation
    public void test(){
        System.out.println("测试aop通过注解拦截");
    }
}
