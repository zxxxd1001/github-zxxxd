package com.git.zxxxd.common;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

@Component
public class PathUtils {

    @PostConstruct
    public void init(){
        try {
            InputStream jsonFilePath = this.getClass().getClassLoader().getResourceAsStream("application.properties");
            Properties p=new Properties();
            p.load(jsonFilePath);
            System.out.println( "getPath1："+p.getProperty("server.port"));
        } catch (Exception e) {
            System.out.println("=====================getPath1====获取路径错误==============");
        }

        try {
            String jsonFilePath=ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX+"application.properties").getPath();
            System.out.println(jsonFilePath);
            Properties p=new Properties();
            p.load(new FileInputStream(jsonFilePath));
            System.out.println( "getPath2："+p.getProperty("server.port"));
        } catch (Exception e) {
            System.out.println("=====================getPath2====获取路径错误==============");
        }
    }
}
