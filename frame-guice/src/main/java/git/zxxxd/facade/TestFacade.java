package git.zxxxd.facade;

import git.zxxxd.entity.Patient;
import git.zxxxd.utils.BaseFacade;
import jdk.internal.util.xml.impl.Parser;

/**
 * Created by zhangxuedong on 2017/4/9.
 */
public class TestFacade extends BaseFacade{

    public String test(){
        Patient p=entityManager.find(Patient.class,"10010");

        return "test";
    }

}
