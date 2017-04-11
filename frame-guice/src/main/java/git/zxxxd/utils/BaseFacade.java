package git.zxxxd.utils;

import org.hibernate.SQLQuery;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Throwables.propagate;

/**
 * Created by zhangxuedong on 2017/4/10.
 */
public class BaseFacade {
    @Inject
    protected EntityManager entityManager;

    public <T> TypedQuery<T> createQuery(Class<T> type, String query, List<Object> parameters) {
        TypedQuery<T> typedQuery = entityManager.createQuery(query, type);
        for (int i = 0; i < parameters.size(); i++) {
            if (parameters.get(i) instanceof Date) {
                typedQuery.setParameter(i + 1, (Date) parameters.get(i), TemporalType.TIMESTAMP);
            } else {
                typedQuery.setParameter(i + 1, parameters.get(i));
            }
        }
        return typedQuery;
    }

    public <T> TypedQuery<T> createQuery(Class<T> type, String query, Object... parameters) {
        TypedQuery<T> typedQuery = entityManager.
                createQuery(query, type);
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i] instanceof Date) {
                typedQuery.setParameter(i + 1, (Date) parameters[i], TemporalType.DATE);
            } else {
                typedQuery.setParameter(i + 1, parameters[i]);
            }
        }
        return typedQuery;
    }

    protected int update(String queryStr, Object... parameters) {
        try {
            Query query = entityManager.createQuery(queryStr);
            for (int i = 0; i < parameters.length; i++) {
                if (parameters[i] instanceof Date) {
                    query.setParameter(i + 1, (Date) parameters[i], TemporalType.TIMESTAMP);
                } else {
                    query.setParameter(i + 1, parameters[i]);
                }
            }
            int i = query.executeUpdate();
            return i;
        } catch (Exception e) {
            propagate(e);
        }
        return 0;
    }

    public List<Map> createNativeQueryToMap(String sql, Object... params) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        for (int i = 0, length = params.length; i < length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }

    public List<Map> createNativeQueryToMap(String sql, List<Object> params) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE);
        for (int i = 0, length = params.size(); i < length; i++) {
            query.setParameter(i + 1, params.get(i));
        }
        return query.getResultList();
    }

    public <T> List<T> createNativeQuery(Class<T> clazz, String sql, Object... params) {
        Query query = entityManager.createNativeQuery(sql);
        query.unwrap(SQLQuery.class).setResultTransformer(new AliasToBeanResultTransformer(clazz));
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }
}
