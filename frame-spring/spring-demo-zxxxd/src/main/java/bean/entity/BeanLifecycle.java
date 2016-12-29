package bean.entity;

/**
 * Created by 张雪冬 on 2016/12/29.
 */
public class BeanLifecycle {
    public BeanLifecycle() {
        System.out.println("----创建BeanLifecycle----");
    }

    public void beanDestroy() {
        System.out.println("----对象资源释放----");
    }
    public void init(){
        System.out.println("----解析其他配置文件----");
    }
    public void execute(){
        System.out.println("----调用execute()方法----");
    }
}
