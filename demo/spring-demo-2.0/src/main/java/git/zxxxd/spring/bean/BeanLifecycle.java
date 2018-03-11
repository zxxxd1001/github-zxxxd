package git.zxxxd.spring.bean;

public class BeanLifecycle {
    public BeanLifecycle() {
        System.out.println("----创建BeanLifecycle----");
    }

    public void beanDestroy() {
        System.out.println("----对象资源释放----");
    }
    public void init(){
        System.out.println("----调用init----");
    }
    public void execute(){
        System.out.println("----调用execute()方法----");
    }
}
