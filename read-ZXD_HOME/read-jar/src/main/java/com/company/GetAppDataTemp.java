package com.company;

import java.io.File;

/**
 * Created by zhangxuedong on 2017/2/22.
 * 读取c盘用户目录下的AppData.Temp.heren文件夹
 */
public class GetAppDataTemp {
    private static final String tmpdir = System.getProperty("java.io.tmpdir");
    private static final String herenTmpdir = "heren";

    public static String getHerenDir() {
        return getPluginDir(tmpdir, herenTmpdir);
    }

    public static String getPluginDir() {
        return getPluginDir(getHerenDir(), "plugin");
    }

    public static String getPluginJarDir() {
        return getPluginDir(getPluginDir(), "jar");
    }
    public static String getPluginDir(String parent, String child){
        File file = new File(parent, child);
        if(!file.exists()){
            file.mkdir();
        }
        if(parent.substring(parent.length() - 1).equals(File.separator)){
            return parent + child;
        } else {
            return parent + File.separator + child;
        }
    }

    public static void main(String[] args) {
        System.out.println(getPluginJarDir());
    }
}
