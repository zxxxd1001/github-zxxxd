package git.zxxxd.spring.bean.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:jdbc.properties")
@Component
public class ReadProperties {

    /**
     * 读取配置文件之
     *    PropertySource(读取properties) 与 ImportResource(读取xml)
     */
    @Value("${username}")
    private String username;
    @Value("${password}")
    private String password;

    @Value("#{db.driver}")
    private String driver;

    @Override
    public String toString() {
        return "ReadProperties{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
