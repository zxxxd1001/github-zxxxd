package git.zxxxd.spring.bean.annotation;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Order 修改依赖注入 类优先级
 */
@Order(1)
@Component
public class BeanImplTwo implements BeanInterFace {
    @Override
    public void whatYouName() {
        System.out.println("My Name's BeanImplTwo");
    }
}
