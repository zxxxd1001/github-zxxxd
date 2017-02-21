package com.company.client.plugin;

import com.company.GetEnvironmentVariable;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by zhangxuedong on 2017/2/21.
 */
public class ReaderJar {
    public static void main(String[] args) {


        try {
            URL url1 = new URL(GetEnvironmentVariable.getZXDHome()+"/plugin/server/jar/beijing/heren-plugin-insurance-beijing-v1.8/heren-plugin-insurance-beijing-v1.8-0.2.2-SNAPSHOT.jar");
            URLClassLoader myClassLoader1 = new URLClassLoader(new URL[] { url1 }, Thread.currentThread()
                    .getContextClassLoader());
            Class<?> myClass1 = myClassLoader1.loadClass("com.heren.his.plugin.insurance.beijing.Apportion");
            System.out.println(myClass1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
