package git.zxxxd.module;

import com.google.inject.AbstractModule;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.ServletModule;

import java.util.Properties;

/**
 * Created by zhangxuedong on 2017/4/9.
 */
public class DBModule extends AbstractModule{
    protected void configure() {
        // 先进行事物控制
        bind(PersistFilter.class);

        install(new JpaPersistModule("jpaUnit").properties(toProperties()));

        // 先进行事物控制
        install(new ServletModule() {
            @Override
            protected void configureServlets() {
                filter("/api/*").through(PersistFilter.class);
            }
        });
    }

    public Properties toProperties() {
        Properties properties = new Properties();
        properties.put("javax.persistence.jdbc.driver", "oracle.jdbc.driver.OracleDriver");
        properties.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@192.168.2.89:1521:orcl");
        properties.put("javax.persistence.jdbc.user", "hrtest");
        properties.put("javax.persistence.jdbc.password", "hrtest");
        return properties;
    }
}
