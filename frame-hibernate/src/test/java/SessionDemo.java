import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import entity.Patient;
import entity.Students;
import oracle.sql.BLOB;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

/**
 * Created by zhangxuedong on 2017/3/28.
 */
public class SessionDemo {
    private Session sessions;
    @Before
    public void before(){
        Configuration configuration=new Configuration().configure();
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory=new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
        Session session=sessionFactory.openSession();
        Session session1=sessionFactory.openSession();//手工关闭session  不管会导致内存溢出
        if(session!=null){
            System.out.println("====================openSession获取session");
            System.out.println("生成session对象");
        }
        System.out.println(session==session1);
        System.out.println("session："+session.hashCode()+"\nsession1："+session1.hashCode());

        //设置自动提交
        session.doWork(new Work() {
            public void execute(Connection connection) throws SQLException {
                connection.setAutoCommit(true);
            }
        });

        Session session2=sessionFactory.getCurrentSession();//事物提交后自动关闭 单例模式 下次在取 对象是一样的
        Session session3=sessionFactory.getCurrentSession();
        if(session2!=null){
            System.out.println("====================getCurrentSession获取session");
            System.out.println("生成session对象");
        }
        System.out.println(session2==session3);
        System.out.println("session2："+session2.hashCode()+"\nsession3："+session3.hashCode());
        sessions=sessionFactory.getCurrentSession();
    }
    @Test
    public void test(){
        try {
            Transaction transaction=sessions.beginTransaction();
            Patient patient=new Patient();
            patient.setName("张三");
            patient.setBirthday(new Date());
            patient.setMoney(new BigDecimal(0.98));
            InputStream in=new FileInputStream(this.getClass().getResource("patImage.jpg").getPath());
            Blob  b= Hibernate.getLobCreator(sessions).createBlob(in,in.available());
            patient.setPicture(b);
            Students s=new Students();
            s.setSid(78);
            s.setGender("组件component");
            patient.setStudents(s);
            sessions.save(patient);
            transaction.commit();
            in.close();

//            Patient p=sessions.get(Patient.class,"402882415b18f804015b18f806e00000");
//            Blob bb=p.getPicture();
//            InputStream inputStream=bb.getBinaryStream();
//            OutputStream out=new FileOutputStream("./test.jpg");
//            int len = -1;
//            byte[] buf = new byte[1024*10];
//
//            while((len = inputStream.read(buf))!=-1){
//                out.write(buf,0,len);
//            }
//            inputStream.close();
//            out.close();


            sessions.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @After
    public void after(){
    }
}
