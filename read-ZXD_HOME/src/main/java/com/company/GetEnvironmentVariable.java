package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GetEnvironmentVariable {

    private static Map<String, String> systemProperty = new HashMap();
    private static final String ZXD_HOME = "ZXD_HOME";

    static{
        try {
            reloadAll();
        } catch (Exception e) {
            throw new RuntimeException(e.toString());
        }
    }

    private static void reloadAll() {
        if (systemProperty == null)
            systemProperty = new HashMap();
        strageSystemProperty();
    }

    private static void strageSystemProperty() {
        try {
            systemProperty = System.getenv();
        } catch (Exception e) {
            System.out.println("systemProperty is wrong");
        }
    }
    public static void output(){
        Set keySet = systemProperty.keySet();

        Iterator it = keySet.iterator();

        while(it.hasNext()) {

            Object key = it.next();

            Object value = systemProperty.get(key);

            System.out.println(key+":"+value);

        }
    }

    public static String getSystemPath(String key) {
        String str = "";
        if (systemProperty != null) {
            if (systemProperty.containsKey(key)) {
                str = systemProperty.get(key);
            }
        }
        return str;
    }

    public static String getZXDHome() {
        return getSystemPath(ZXD_HOME);
    }

    public static void main(String[] args) {
        System.out.println("测试读取环境变量信息！！！");
        output();
        System.out.println();
        System.out.println("ZXD_HOME环境变量值为："+getZXDHome());
        System.out.println("读取完成！！！");
    }
}
