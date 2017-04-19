package git.jsr330;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Service
public class JsrService {
    @Inject
    private JsrDAO jsrDAO;

    @Inject
    private List<BeanInterface> beanInterface;

    @Inject
    @Named("beanImplOne")
    private BeanInterface b;

    public void save(){
        jsrDAO.save();
       for(BeanInterface b:beanInterface){
           System.out.println(b.getClass().getName());
       }
        System.out.println(b.getClass().getName());
    }
}
