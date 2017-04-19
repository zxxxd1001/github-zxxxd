package multipleClass.implementInterfaceTest;

import bean.multipleClass.implementInterface.AppModule;
import bean.multipleClass.implementInterface.ReadProperties;
import bean.multipleClass.implementInterface.Store;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppModule.class)
public class TestRead {
    @Resource
    private ReadProperties readProperties;

    @Resource
    private Store<String> s1;

    @Resource
    private Store<Integer> s2;

    @Autowired
    private List<Store<Long>> list;

    @Test
    public void test(){
        System.out.println(readProperties.toString());

        System.out.println(s1.getClass().getName());
        System.out.println(s2.getClass().getName());

        if(list.isEmpty()){
            System.out.println("list是空的。");
        }else{
            for(Store<Long> store:list){
                System.out.println(store.getClass().getName());
            }
        }
    }
}
