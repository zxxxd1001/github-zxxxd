package com.company.client.plugin;

import com.company.GetEnvironmentVariable;
import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.heren.his.commons.plugin.client.PluginBase;
import com.heren.his.commons.plugin.client.PluginEvent;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.xeustechnologies.jcl.JarClassLoader;

import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * Created by zhangxuedong on 2017/2/21.
 */
public class PluginManager {
    private static List<URL> urlList = Lists.newArrayList();
    private static Map<String, Set<? extends PluginBase>> pluginEvents = Collections.synchronizedMap(new HashMap<String, Set<? extends PluginBase>>());

    public PluginManager() {
    }

    static {
        try {
            reloadAllListners();
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    private static void reloadAllListners() throws Exception {

        Set<Class<? extends PluginBase>> aopTranBaseSet = getAopEventBaseClasses();

        for (Class<? extends PluginBase> c : aopTranBaseSet) {

            String className = c.getSimpleName();
            if (pluginEvents.containsKey(className)) {
                ImmutableSet.Builder<PluginBase> builder = ImmutableSet.builder();
                Set<? extends PluginBase> aopEventBaseList = pluginEvents.get(className);
                builder.addAll(aopEventBaseList);

                PluginBase aopEventBase = c.getConstructor().newInstance();
                builder.add(aopEventBase);

                pluginEvents.remove(className);
                ImmutableSortedSet<PluginBase> sorted = getOrderedAopEventBases(builder.build());
                pluginEvents.put(className, sorted);
            } else {
                ImmutableSet.Builder<PluginBase> builder = ImmutableSet.builder();
                builder.add(c.getConstructor().newInstance());
                pluginEvents.put(className, builder.build());

            }

        }
    }

    private static Set<Class<? extends PluginBase>> getAopEventBaseClasses() throws Exception {
        String jarDir = GetEnvironmentVariable.getZXDHome()+"/zxd";
        Reflections reflections = getReflectionsForServer(jarDir);
        return reflections.getSubTypesOf(PluginBase.class);
    }

    private static Reflections getReflectionsForServer(String pluginPath) {
        Reflections reflections;
        getAllPluginUrl(pluginPath);

        if (urlList.isEmpty()) {
            reflections = new Reflections("com.heren.his.plugin");
        } else {
            JarClassLoader jcl = new JarClassLoader();
            for (URL url : urlList) {
                jcl.add(url);
            }

            ConfigurationBuilder config = new ConfigurationBuilder();
            config.addClassLoader(jcl);

            config.setUrls(urlList);
            reflections = new Reflections(config);
        }
        return reflections;
    }

    private static void getAllPluginUrl(String path) {

        File pulginPath = new File(path);
        if (!pulginPath.exists()) {

        }
        try {
            if (pulginPath.list() != null) {
                for (String f : pulginPath.list()) {
                    String pathname = pulginPath.getAbsolutePath() + File.separator + f;
                    File fl = new File(pathname);
                    if (fl.isDirectory()) {
                        getAllPluginUrl(pathname);
                    } else {
                        if (f.indexOf(".jar") > 0) {
                            URL url = fl.toURL();
                            urlList.add(url);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ImmutableSortedSet<PluginBase> getOrderedAopEventBases(ImmutableSet<PluginBase> build) {
        Function<PluginBase, Double> getSortFunction = new Function<PluginBase, Double>() {
            public Double apply(PluginBase from) {
                Random r = new Random();
                return from.getSort() + r.nextDouble();
            }
        };
        Ordering<PluginBase> ordering = Ordering.natural().onResultOf(getSortFunction);

        return ImmutableSortedSet.orderedBy(ordering).addAll(build).build();
    }


    private static String getEventById(String eventId) {
        StringBuffer temp = new StringBuffer();
        Iterable<String> iterable = Splitter.on('_').split(eventId);
        for (String key : iterable) {
            String first = key.substring(0, 1);
            String left = key.substring(1, key.length());
            temp.append(first.toUpperCase()).append(left);
        }

        return temp.toString();
    }

    public static PluginEvent sendTransToPlugin(String eventId, Object objectIdentifier, Object businessObject) {
        PluginEvent pluginEvent = new PluginEvent(eventId, objectIdentifier, businessObject);
        return execPluginEvent(eventId, pluginEvent);
    }

    private static PluginEvent execPluginEvent(String eventId, PluginEvent pluginEvent) {
        String eventIdNew = getEventById(eventId);
        Set<? extends PluginBase> aopEventBases = pluginEvents.get(eventIdNew);
        if (aopEventBases != null) {
            for (PluginBase aopEvent : aopEventBases) {
                aopEvent.init(new Object());
                aopEvent.plugin(pluginEvent);
                if (pluginEvent.getCancel()) {
                    return pluginEvent;
                }
            }
        }
        return pluginEvent;
    }
}
