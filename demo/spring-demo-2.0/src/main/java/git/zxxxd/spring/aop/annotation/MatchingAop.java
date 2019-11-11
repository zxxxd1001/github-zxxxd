package git.zxxxd.spring.aop.annotation;

import org.springframework.stereotype.Component;

@Component
public class MatchingAop {
    @AopAnntation
    public void test(){
        System.out.println("测试aop通过注解拦截");
    }

    @AopAnntation
    public int set(int i,int y){
        return i+y;
    }

    @OnException("执行方法失败")
    public void testEx(){
        int i=new Integer(null);
    }
}
