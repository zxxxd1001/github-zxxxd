package git.zxxxd.start;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlConfiguration;

import java.io.IOException;

/**
 * Created by zhangxuedong on 2017/3/22.
 */
public class FileServerXml {
    public static void main(String[] args) {
        try {
            //读取xml
            Resource resource= Resource.newSystemResource("fileserver.xml");
            XmlConfiguration configuration=new XmlConfiguration(resource.getInputStream());
            Server server=(Server) configuration.configure();
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
