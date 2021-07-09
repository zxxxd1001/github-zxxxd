package demo.annotation;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public void outputService() {
        System.out.println("从组合注解配置照样获得bean");
    }

}
