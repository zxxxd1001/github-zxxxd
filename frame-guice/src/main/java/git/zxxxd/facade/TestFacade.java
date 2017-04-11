package git.zxxxd.facade;

import git.zxxxd.entity.Patient;
import git.zxxxd.entity.PatientTow;
import git.zxxxd.utils.AliasToBeanResultTransformer;
import git.zxxxd.utils.AliasToEntityMapResultTransformer;
import git.zxxxd.utils.BaseFacade;
import jdk.internal.util.xml.impl.Parser;
import org.hibernate.SQLQuery;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by zhangxuedong on 2017/4/9.
 */
public class TestFacade extends BaseFacade{

    public String test(){
        Patient p=entityManager.find(Patient.class,"10010");
        Query query=entityManager.createNativeQuery("select patient_id from pat_master_index");
        query.unwrap(SQLQuery.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        List list=query.getResultList();

        Query query2= entityManager.createNativeQuery("select patient_id from pat_master_index");
        query2.unwrap(SQLQuery.class).setResultTransformer(new AliasToBeanResultTransformer(PatientTow.class));
        List list1=query2.getResultList();
        return "test";
    }

}
