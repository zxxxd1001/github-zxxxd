package git.zxxxd.spring.bean.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component(value="lifecycle")
@Scope(value="singleton")
//@Scope(value="prototype")
/**
 * singleton 单利模式 启动spring时会实例化对象
 * prototype 原型模式 每次获取的都是新创建的对象
 */
public class BeanLifecycle {
    public BeanLifecycle() {
        System.out.println("----创建BeanLifecycle----");
    }

    @PreDestroy
    public void beanDestroy() {
        System.out.println("----对象资源释放----");
    }
    @PostConstruct
    public void init(){
        System.out.println("----调用init----");
    }
    public void execute(){
        System.out.println("----调用execute()方法----");
    }
}
