package aop.test.service;

/**
 * Created by zhangxuedong on 2017/4/20.
 */
public interface PersonServer {
    void save(String name);
    void update(String name,int id);
    void getPersonName(int id);
}
