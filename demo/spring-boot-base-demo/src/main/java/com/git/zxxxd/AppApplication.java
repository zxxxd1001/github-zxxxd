package com.git.zxxxd;

import com.git.zxxxd.config.ImportSelect;
import com.git.zxxxd.config.MyAware;
import com.git.zxxxd.filter.MyFilter;
import com.git.zxxxd.filter.SpringFilter;
import com.git.zxxxd.listener.MyListener;
import com.git.zxxxd.servlet.MyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Collections;

@SpringBootApplication
@Import(ImportSelect.class)
@EnableAsync
public class AppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new SpringFilter());
        frBean.setName("SpringFilter");
        frBean.addUrlPatterns("/*");
        return frBean;
    }
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new MyFilter());
        frBean.setName("MyFilter");
        frBean.addUrlPatterns("/*");
        return frBean;
    }
}