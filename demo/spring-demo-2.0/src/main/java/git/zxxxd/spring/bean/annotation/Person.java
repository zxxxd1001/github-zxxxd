package git.zxxxd.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * spring @Autowired默认是通过byType的方式自动注入的，
 *  Resource默认是用过byName的方式自动注入的。
 */
@Component
public class Person {

    private String name;

    @Resource(name="beanImplOne")
    private BeanInterFace beanInterFace;

    @Autowired
    private List<BeanInterFace> beanInterFaces;

    @Autowired
    public Person(@Qualifier("zhang") String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public BeanInterFace getBeanInterFace() {
        return beanInterFace;
    }

    public void setBeanInterFace(BeanInterFace beanInterFace) {
        this.beanInterFace = beanInterFace;
    }

    public List<BeanInterFace> getBeanInterFaces() {
        return beanInterFaces;
    }

    public void setBeanInterFaces(List<BeanInterFace> beanInterFaces) {
        this.beanInterFaces = beanInterFaces;
    }
}
