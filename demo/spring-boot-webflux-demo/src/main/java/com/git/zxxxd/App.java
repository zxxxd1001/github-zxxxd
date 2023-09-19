package com.git.zxxxd;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Reactive Spring 实战 -- WebFlux 使用教程
 *    https://zhuanlan.zhihu.com/p/344878241
 *
 * WebFlux 是 Spring 5 提供的响应式 Web 应用框架。
 * 它是完全非阻塞的，可以在 Netty，Undertow 和 Servlet 3.1 + 等非阻塞服务器上运行。
 *
 * projectreactor.io
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        //WebApplicationType.REACTIVE 启动 WebFlux。
        new SpringApplicationBuilder(App.class).web(WebApplicationType.REACTIVE).run(args);
    }

}
