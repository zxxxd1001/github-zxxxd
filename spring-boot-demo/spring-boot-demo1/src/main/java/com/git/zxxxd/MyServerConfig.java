package com.git.zxxxd;

import com.git.zxxxd.Filter.MyFilter;
import com.git.zxxxd.listener.MyListener;
import com.git.zxxxd.servlet.MyServlet;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class MyServerConfig {

    @Bean
    public EmbeddedServletContainerCustomizer embeddedServletContainerCustomizer(){
        //设置tomcat的具体配置
        return new EmbeddedServletContainerCustomizer() {
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                configurableEmbeddedServletContainer.setPort(8001);
            }
        };
    }

    //配置servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new MyServlet());
        servletRegistrationBean.setUrlMappings(Collections.singleton("/myServlet"));
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new MyFilter());
        registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
        return registrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean=new ServletListenerRegistrationBean(new MyListener());
        return servletListenerRegistrationBean;
    }

}
