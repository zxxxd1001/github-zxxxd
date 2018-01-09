package git.zxxxd;


import com.sun.jersey.api.core.DefaultResourceConfig;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class MyRestWebService extends PackagesResourceConfig{
    public MyRestWebService() {
        super("git.zxxxd.resource");
    }
}
