package git.jsr330;

import org.springframework.stereotype.Repository;

@Repository
public class JsrDAO {

    public void save(){
        System.out.println("保存！");
    }
}
