package com.git.zxxxd.bean;

import org.springframework.beans.factory.InitializingBean;

public class MyBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("123123");
    }
}
