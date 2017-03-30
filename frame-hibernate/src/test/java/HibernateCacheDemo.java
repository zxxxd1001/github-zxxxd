import entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;


/**
 * Created by zhangxuedong on 2017/3/29.
 */
public class HibernateCacheDemo {
    Configuration configuration=new Configuration().configure();
    SessionFactory sessionFactory=configuration.buildSessionFactory();
    private Session getSession(){
        return sessionFactory.openSession();
    }

    @Test
    public void testCache(){
        /**
         * 一级缓存：会话级缓存是和session相关的
         * 其生命周期也和session相同。
         * 一级缓冲的数据可适用的范围在当前会话之内(同一个session)
         */
        Session session=getSession();
        Students students=session.get(Students.class,1234);
        System.out.println(students.getName());

//        evict清除一级缓冲指定对象
//        session.evict(students);
//        clear清除缓冲中所有对象
//        session.clear();

        //session=getSession();
        students=session.get(Students.class,1234);
        System.out.println(students.getName());
        session.close();

        Query s=session.createQuery("");
        //Query.list(); 不会查到一级缓存

        //Query.iterate();

        //二级缓存 需要加载ehcache 手动开启 一级缓冲hibernate开启不可关闭
    }
}
