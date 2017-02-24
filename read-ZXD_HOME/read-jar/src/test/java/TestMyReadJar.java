import com.company.GetEnvironmentVariable;
import com.git.zxd.PluginBase;
import com.git.zxd.PluginEvent;
import com.test.zxd.PluginManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by zhangxuedong on 2017/2/23.
 */
public class TestMyReadJar {
    public static void main(String[] args) throws  Exception {
//        PluginManager.sendTransToPlugin("TestPluginClient", "231", "123123");

        //测试方式一
        String path="file:"+GetEnvironmentVariable.getZXDHome()+"/zxd/zxd-test-client.jar";
        URL url = new URL(path);
        URLClassLoader myClassLoader = new URLClassLoader(new URL[] { url }, Thread.currentThread()
                .getContextClassLoader());
        Class<?> myClass = myClassLoader.loadClass("com.test.zxd.TestPluginClient");
        PluginBase action = (PluginBase) myClass.newInstance();
        PluginEvent pluginEvent=new PluginEvent("TestPluginClient", "231", "123123");
        action.plugin(pluginEvent);
        System.out.println(pluginEvent.getAppendDescription());
    }
}
