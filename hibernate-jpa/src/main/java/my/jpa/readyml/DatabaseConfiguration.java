package my.jpa.readyml;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DatabaseConfiguration{
    private String driver;
    private String url;
    private String password;
    private String user;
    private Map<String, String> properties = new HashMap<String, String>();

    public Properties toProperties() {
        Properties properties = new Properties();

        if (driver != null) properties.put("javax.persistence.jdbc.driver", driver);
        if (url != null) properties.put("javax.persistence.jdbc.url", url);
        if (password != null && user != null) {
            properties.put("javax.persistence.jdbc.user", user);
            properties.put("javax.persistence.jdbc.password", password);
        }
        if (this.properties != null)
            for (String key : this.properties.keySet())
                properties.put(key, this.properties.get(key));
        return properties;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }
}
