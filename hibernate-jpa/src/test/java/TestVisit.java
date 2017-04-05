import entity.InsurPatient;
import entity.InsurPatientPK;
import entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

import java.util.EnumSet;

public class TestVisit {
    @Test
    public void test(){
        StandardServiceRegistry standardServiceRegistry=new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata=new MetadataSources(standardServiceRegistry).buildMetadata();
        SchemaExport schemaExport=new SchemaExport();
        schemaExport.create(EnumSet.of(TargetType.DATABASE),metadata);
        SessionFactory sessionFactory=metadata.buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        InsurPatient insurPatient=new InsurPatient();
        insurPatient.setName("测试数据");
        InsurPatientPK insurPatientPK=new InsurPatientPK();
        insurPatientPK.setId(1);
        insurPatientPK.setInsurId("1");
        insurPatient.setInsurPatientPK(insurPatientPK);
        session.save(insurPatient);
        Patient patient=new Patient();
        patient.setId(1);
        patient.setPatientId("1");
        patient.setName("测试");
        session.save(patient);

        transaction.commit();
        session.close();

        Session session1=sessionFactory.openSession();
        Patient patient1=session1.get(Patient.class,patient);
        System.out.println(patient1.getName());

        InsurPatient insurPatient1=session1.get(InsurPatient.class,insurPatientPK);
        System.out.println(insurPatient1.getName());

        session1.close();
        sessionFactory.close();
    }
}
