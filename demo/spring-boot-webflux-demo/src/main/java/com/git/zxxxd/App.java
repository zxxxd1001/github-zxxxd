package com.git.zxxxd;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
@RestController
public class App {

    @GetMapping("hello")
    public Mono<String> hello(String input){
        Mono<String> hello = Mono.just("hello");
        Mono<String> word = Mono.justOrEmpty(input).defaultIfEmpty("word");
//        return hello.zipWith(word,(a,b)->{
        return Mono.zip(hello,word,(a,b)->{
            System.out.println(a);
            System.out.println(b);
            return a+","+b;
        });
    }

    public static void main(String[] args) {
        //WebApplicationType.REACTIVE 启动 WebFlux。
        new SpringApplicationBuilder(App.class).web(WebApplicationType.REACTIVE).run(args);
    }

}
