package aop.test.dao;

import aop.test.service.PersonServer;
import org.springframework.stereotype.Component;

@Component
public class PersonServerImpl implements PersonServer {
    @Override
    public void save(String name) {
        System.out.println("保存："+name);
    }

    @Override
    public void update(String name, int id) {
        System.out.println("更新："+id+" 的名字为 "+name);
    }

    @Override
    public void getPersonName(int id) {
        System.out.println("根据id获取名字："+id);
        throw new RuntimeException();
    }
}
