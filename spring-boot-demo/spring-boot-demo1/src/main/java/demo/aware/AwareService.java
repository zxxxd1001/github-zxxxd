package demo.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {
    private String beanName;
    private ResourceLoader loader;

    public void setBeanName(String name) {
        this.beanName = name;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outputResult() {
        System.out.println("Bean的名称为" + beanName);
//        Resource resource = loader.getResource("classpath:spring/demo.aware/test.txt");
//        try {
//            System.out.println(String.format("ResourceLoader加载的文件内容为：%s",resource.getInputStream().toString()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
