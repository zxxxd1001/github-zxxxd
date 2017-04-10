package git.zxxxd.utils;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Created by zhangxuedong on 2017/4/10.
 */
public class BaseFacade {
    @Inject
    protected EntityManager entityManager;

}
