package com.git.zxxxd.domain;

import com.git.zxxxd.domain.interceptor.TestInterceptor;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ServletComponentScan
public class MyConfiguration implements WebMvcConfigurer {
    /** 解决跨域问题
    public void addCorsMappings(CorsRegistry registry) ;
        添加拦截器
    void addInterceptors(InterceptorRegistry registry);
        这里配置视图解析器
    void configureViewResolvers(ViewResolverRegistry registry);
        配置内容裁决的一些选项
    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
        视图跳转控制器
    void addViewControllers(ViewControllerRegistry registry);
        静态资源处理
    void addResourceHandlers(ResourceHandlerRegistry registry);
        默认静态资源处理器
    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);
    **/

//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/api").setViewName("hello.html");
//    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**").excludePathPatterns("/hello.html");
//        WebMvcConfigurer.super.addInterceptors(registry);
    }
    //配置静态文件路径
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        WebMvcConfigurer.super.addResourceHandlers(registry);
//
//    }

    //使用@WebFilter("/*")配置filter需要开启ServletComponentScan注解
//    @Bean
//    public FilterRegistrationBean filterRegist() {
//        FilterRegistrationBean frBean = new FilterRegistrationBean();
//        frBean.setFilter(new SpringFilter());
//        frBean.setName("SpringFilter");
//        frBean.addUrlPatterns("/*");
//        return frBean;
//    }

//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    @Bean
//    public ServletListenerRegistrationBean listenerRegist() {
//        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
//        srb.setListener(new MyHttpSessionListener());
//        System.out.println("listener");
//        return srb;
//    }
}
