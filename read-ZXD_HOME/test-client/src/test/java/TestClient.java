
import com.git.zxd.PluginEvent;
import com.test.zxd.TestPluginClient;

/**
 * Created by zhangxuedong on 2017/2/23.
 */
public class TestClient {
    public static void main(String[] args) {
        TestPluginClient testPluginClient=new TestPluginClient();
        PluginEvent pluginEvent=new PluginEvent("TestPluginClient","0","");
        testPluginClient.plugin(pluginEvent);
        System.out.println(pluginEvent.getAppendDescription());
    }
}
