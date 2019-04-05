package com.git.zxxxd.starter;

public class SayHelloService {
    private SayHelloProperties helloProperties;

    public String sayHello(String name) {
        return helloProperties.getPrefix() + " - " + name + " - " + helloProperties.getSuffix();
    }

    public SayHelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(SayHelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }
}
