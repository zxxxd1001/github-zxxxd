import entity.IdCard;
import entity.Score;
import entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Created by zhangxuedong on 2017/3/31.
 */
public class TesOneToOne {
    @Test
    public void test(){
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata= new MetadataSources().buildMetadata(standardServiceRegistry);
        SchemaExport schemaExport=new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE),metadata);

        SessionFactory sessionFactory=metadata.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();

        Students students=new Students();
        students.setName("测试");
        students.setId(1);
        IdCard idCard=new IdCard();
        idCard.setpId(2);
        idCard.setSax("a");
        students.setIdCard(idCard);
        Score score=new Score(1,students.getId(),"100");
        Score score2=new Score(2,students.getId(),"96");
        List<Score> list=new ArrayList<Score>();
        list.add(score);
        list.add(score2);
        students.setScore(list);

        session.save(students);

        transaction.commit();
        session.close();

        Session session1=sessionFactory.openSession();
        Transaction transaction1=session1.beginTransaction();

        IdCard idCard1=session1.get(IdCard.class,2);
        System.out.println(idCard1.getSax());

        Students students1=session1.get(Students.class,1);
        System.out.println(students1.getIdCard().getSax());

        session1.remove(students1);

        transaction1.commit();
        session1.close();
        sessionFactory.close();
    }
}
