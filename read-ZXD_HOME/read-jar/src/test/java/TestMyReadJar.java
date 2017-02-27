import com.company.GetEnvironmentVariable;
import com.git.zxd.PluginBase;
import com.git.zxd.PluginEvent;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.test.zxd.PluginManager;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.xeustechnologies.jcl.JarClassLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

/**
 * Created by zhangxuedong on 2017/2/23.
 */
public class TestMyReadJar {
    public static void main(String[] args) throws  Exception {
//        PluginManager.sendTransToPlugin("TestPluginClient", "231", "123123");
        PluginEvent pluginEvent=new PluginEvent("TestPluginClient", "231", "123123");
        //测试方式一
//        String path="file:"+GetEnvironmentVariable.getZXDHome()+"/zxd/zxd-test-client.jar";
//        URL url = new URL(path);
//        URLClassLoader myClassLoader = new URLClassLoader(new URL[] { url }, Thread.currentThread()
//                .getContextClassLoader());
//        Class<?> myClass = myClassLoader.loadClass("com.test.zxd.TestPluginClient");
//        PluginBase action = (PluginBase) myClass.newInstance();

//        action.plugin(pluginEvent);
//        System.out.println(pluginEvent.getAppendDescription());
        //测试方法二
        File pulginPath = new File(GetEnvironmentVariable.getZXDHome()+"/zxd");
        List<URL> urlList = Lists.newArrayList();
        Map<String, Set<? extends PluginBase>> pluginEvents = Collections.synchronizedMap(new HashMap<String, Set<? extends PluginBase>>());
        JarClassLoader jcl = new JarClassLoader();
        if (pulginPath.list() != null) {
            for (String f : pulginPath.list()) {
                String pathname = pulginPath.getAbsolutePath() + File.separator + f;
                File fl = new File(pathname);
                if (f.indexOf(".jar") > 0) {
                    URL url =fl.toURL();
                    urlList.add(url);
                    jcl.add(fl.toURL());
                }
            }
            ConfigurationBuilder config = new ConfigurationBuilder();
            config.addClassLoader(jcl);
            config.setUrls(urlList);
            Reflections reflections = new Reflections(config);
            Set<Class<? extends PluginBase>> aop= reflections.getSubTypesOf(PluginBase.class);
            for (Class<? extends PluginBase> c : aop) {
                String className = c.getSimpleName();
                ImmutableSet.Builder<PluginBase> builder = ImmutableSet.builder();
                builder.add(c.getConstructor().newInstance());
                pluginEvents.put(className, builder.build());
            }
            Set<? extends PluginBase> aopEventBases = pluginEvents.get(pluginEvent.getEventId());
            if (aopEventBases != null) {
                Iterator<?  extends PluginBase> c=aopEventBases.iterator();
                for (PluginBase aopEvent : aopEventBases) {
                    aopEvent.init(new Object());
                    aopEvent.plugin(pluginEvent);
                }
            }
            System.out.println(pluginEvent.getAppendDescription());
        }
    }
}
