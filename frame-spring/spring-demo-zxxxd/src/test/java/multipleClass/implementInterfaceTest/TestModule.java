package multipleClass.implementInterfaceTest;

import bean.multipleClass.implementInterface.AppModule;
import bean.multipleClass.implementInterface.BeanImplOne;
import bean.multipleClass.implementInterface.BeanInterFace;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 注入方式的测试 重点在：如果一个接口被多个类实现时。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppModule.class)
public class TestModule {

    @Autowired
    private List<BeanInterFace> beanInterFaceList;

    @Autowired
    private Map<String, BeanInterFace> map;

    /**
     * Could not autowire. There is more than one bean of 'BeanInterFace' type.
     * Beans:
     * beanImplOne   (BeanImplOne.java) beanImplTwo   (BeanImplTwo.java)
     *
     * 多个实现会报错
     * @Autowired
     * private BeanInterFace beanInterFace;
     */
    //spring首先查找  接口实现类 找到以后 根据属性名 查找对应bean 应为spring bean id 一定是唯一的。
    @Autowired
    private BeanInterFace beanImplOne;

    @Autowired
    @Qualifier("beanImplTwo")
    private BeanInterFace beanInterFace;

    @Autowired
    private BeanImplOne beanImplOne2;

    @Resource
    private BeanInterFace beanImplTwo;

    /**
     * 知识点：spring @Autowired默认是通过byType的方式自动注入的，
     *  Resource默认是用过byName的方式自动注入的。
     *
     *  Order 可以设置类加载的顺序 只可以针对
     */

    @Test
    public void test() {
        if (beanInterFaceList.isEmpty()) {
            System.out.println("没有找到实现类");
        } else {
            for (BeanInterFace beanInterFace : beanInterFaceList) {
                beanInterFace.whatYouName();
            }
        }

        if (map.isEmpty()) {
            System.out.println("没有找到实现类");
        } else {
            for (Map.Entry<String, BeanInterFace> beanInterFaceMap : map.entrySet()) {
                System.out.println(beanInterFaceMap.getKey() + ":" + beanInterFaceMap.getValue());
            }
        }

        beanImplOne.whatYouName();

        beanInterFace.whatYouName();

        beanImplOne2.whatYouName();

        beanImplTwo.whatYouName();

    }
}
