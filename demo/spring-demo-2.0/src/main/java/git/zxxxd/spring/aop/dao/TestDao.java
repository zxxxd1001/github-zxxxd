package git.zxxxd.spring.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class TestDao {
    public void save(){
        System.out.println("保存方法！");
    }
}
