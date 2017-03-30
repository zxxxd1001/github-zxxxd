import entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by zhangxuedong on 2017/3/29.
 */
public class TestGetOrLoad {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void before() {
        Configuration configuration=new Configuration().configure();
        sessionFactory=configuration.buildSessionFactory();
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
    }

    @Test
    public void testSave(){
        Students s=new Students();
        s.setSid(1);
        s.setName("张三");
        s.setBirthday(new Date());
        session.save(s);
    }

    @Test
    public void testGet(){
        Students s=session.get(Students.class,1);
        if(s==null){
            System.out.println("get查询数据库时，没有对象返回的是null");
        }else {
            System.out.println(s.getClass().getName());
        }
    }
    @Test
    public void testLoad(){
        try {
            Students s=session.load(Students.class,1);
            System.out.println(s.getClass().getName());
            System.out.println(s.getName());
        } catch (Exception e) {
            System.out.println("load查询数据库时，没有对象会抛ObjectNotFoundException异常");
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdate(){
        Students s=session.load(Students.class,1);
        s.setName("李四");
        s.setAddress("update");
        session.update(s);
    }
    @Test
    public void testDelete(){
        Students s=session.load(Students.class,1);
        session.delete(s);
    }

    @After
    public void after(){
        transaction.commit();
        sessionFactory.close();
        session.close();
    }
}
