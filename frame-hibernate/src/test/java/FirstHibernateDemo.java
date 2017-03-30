import entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;


public class FirstHibernateDemo {

    //创建和销毁都相当消耗资源，通常一个系统内一数据库只创建一个
    private SessionFactory sessionFactory;
    //session对象类似于数据库 connection
    //获得了session对象 就是获得了数据库连接对象 可以进行增删改查
    private Session session;
    private Transaction transaction;

    @Before
    public void before() {
        System.out.println("初始化");
        //创建配置对象  读取配置文档hibernate.cfg.xml
        Configuration configuration = new Configuration().configure();
        //创建服务注册对象
//        ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        //创建会话工厂对象
//        sessionFactory=configuration.buildSessionFactory(serviceRegistry);

//        StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
//        sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

        sessionFactory = configuration.buildSessionFactory();
        //会话对象
        session = sessionFactory.openSession();
        //开启事务
        transaction = session.beginTransaction();
    }

    @Test
    public void test() {
        System.out.println("测试类");
        Students s = new Students();
        s.setName("张三");
        s.setGender("gender");
        s.setBirthday(new Date());
        s.setAddress("address");
        s.setSid(1234);
        session.save(s);
    }

    @After
    public void after() {
        System.out.println("释放资源");
        transaction.commit();//提交事务
        session.close();//关闭会话
        sessionFactory.close();//关闭会话工厂
    }

}
