package com.git.zxxxd.dependency;

/**
 * 去除依赖 dependency
 */
public class app {
    public static void main(String[] args) {
        MyApplet mainApplet = Configuration.getMainApplet();
        mainApplet.run();
    }
}
