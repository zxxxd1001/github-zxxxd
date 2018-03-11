package git.zxxxd.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class LoggerOutAop {
    public void logger(){
        System.out.println("输出日志!");
    }
}
