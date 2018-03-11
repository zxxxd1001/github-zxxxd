package git.zxxxd.spring.bean.annotation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class BeanImplOne implements BeanInterFace {
    @Override
    public void whatYouName() {
        System.out.println("My Name is BeanImplOne");
    }
}
