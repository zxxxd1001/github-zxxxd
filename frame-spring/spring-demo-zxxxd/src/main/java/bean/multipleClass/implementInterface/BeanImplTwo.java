package bean.multipleClass.implementInterface;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class BeanImplTwo implements BeanInterFace {
    @Override
    public void whatYouName() {
        System.out.println("My Name's BeanImplTwo");
    }
}
