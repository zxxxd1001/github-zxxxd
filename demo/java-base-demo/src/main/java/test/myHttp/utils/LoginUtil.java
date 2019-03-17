package test.myHttp.utils;

import java.util.Map;
import java.util.Properties;

public class LoginUtil {
    protected boolean flag = false;
    private Properties properties;

    public LoginUtil(Properties properties) {
        this.properties = properties;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    // 验证用户信息的合法性（应用JDBC桥，连接数据库）
    public boolean isValid(Map<String, String> values) {

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        if (values.get("username").equals(username)) {
            if (values.get("password").equals(password)) {
                flag = true;
                System.out.println("The user " + values.get("username") + " was log the server.");
                return flag;
            }
        } else {
            System.out.println("Forbide the " + values.get("username") + " log the server");
            return flag;
        }
        return false;
    }
}

