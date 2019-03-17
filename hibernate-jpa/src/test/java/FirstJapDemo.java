import my.jpa.entity.InpAppoint;
import my.jpa.entity.Person;
import my.jpa.readyml.Configuration;
import my.jpa.readyml.JpaConfiguration;
import org.hibernate.Transaction;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangxuedong on 2017/3/31.
 */
public class FirstJapDemo {
    @Test
    public void test() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaUnit", getProperties());
        entityManagerFactory.close();
    }

    @Test
    public void save() {
        Map property = getProperties();
        try {
            JpaConfiguration configuration = Configuration.read(fixture("/config.yml"), JpaConfiguration.class);
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaUnit", configuration.getDatabase().toProperties());
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();//开启事物

            Person person = new Person();
            person.setSax("男");
            person.setName("张三");
            person.setAge(21);
            entityManager.persist(person);
            entityTransaction.commit();

            entityManager.clear();

            person = entityManager.find(Person.class, "张三");
            System.out.println(person.getAge());

            entityManager.close();
            entityManagerFactory.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private InputStream fixture(String fixture) {
        return getClass().getResourceAsStream(fixture);
    }

    private Map getProperties() {
        Map property = new HashMap();
        property.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
        property.put("hibernate.connection.url", "jdbc:oracle:thin:@10.10.82.192:1521:orcl");
        property.put("hibernate.connection.username", "herendh");
        property.put("hibernate.connection.password", "herendh");
        property.put("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
        property.put("hibernate.hbm2ddl.auto", "create");
        property.put("hibernate.show_sql", "true");
        return property;
    }

    @Test
    public void testXmlJavaTypeAdapter() throws Exception {
        JpaConfiguration configuration = Configuration.read(fixture("/config.yml"), JpaConfiguration.class);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaUnit", configuration.getDatabase().toProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();//开启事物

        InpAppoint ia=new InpAppoint();
        ia.setApplyNo("20180003839");
        ia.setAppointAdtStatus(InpAppoint.AppointAdtType.APPOINTED.getValue());
        ia.setCancelDateTime(new Date());
        ia.setDeptAdmissionTo("123124");
        ia.setPatientId("90000000");
        entityManager.persist(ia);
        entityTransaction.commit();
        entityManager.clear();

        InpAppoint a=entityManager.find(InpAppoint.class,"20180003839");
        entityManager.close();
        entityManagerFactory.close();
    }
}
