package bean.multipleClass.implementInterface;

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

    @Override
    public String toString() {
        return "username='" + username + '\'' +
                ", password='" + password ;
    }
}
