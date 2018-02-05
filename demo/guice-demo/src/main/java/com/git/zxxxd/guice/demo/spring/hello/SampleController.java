package com.git.zxxxd.guice.demo.spring.hello;

import com.git.zxxxd.guice.demo.spring.hello.guiceCode.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@SpringBootApplication
@ServletComponentScan
public class SampleController {

    @Bean Injector getInject(ApplicationContext context){
        return Guice.createInjector(new GuiceModule()
                ,new SpringAwareServletModule(context));
    }
    @Bean @RequestScope
    GreetingHandler getGreetingHandler(Injector injector){
        return injector.getInstance(GreetingHandler.class);
    }

    @Autowired
    private GreetingHandler greetingHandler;

    @GetMapping("/hello")
    String home(@RequestParam("param")String str) {
        return greetingHandler.getResult(str);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}