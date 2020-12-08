package com.git.zxxxd.config;
import java.nio.charset.Charset;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.git.zxxxd.filter.XssStringJsonSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * @ClassName: WebMvcConfiguration
 * @Description: 注册RequestJsonNode的参数解析器
 * @author maoht
 * @date 2018年3月7日 下午3:32:07
 * @version V1.0
 */
//@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

        // 添加RequestJsonNode的参数解析器
        /***
         * 取消对JSON返回值的支持，修改为对象返回 by hanzaihua since 20180524
         */
        //argumentResolvers.add(new RequestJsonNodeMethodArgumentResolver());
        super.addArgumentResolvers(argumentResolvers);
    }

    /**
     *
     * @Title: responseBodyConverter
     * @Description: 处理中文乱码问题
     * @return HttpMessageConverter<String>
     * @author jxxiong
     * @throws @date
     *             2018年3月5日 下午5:18:37
     * @version V1.0
     */
    @Bean
    public HttpMessageConverter<String> stringHttpMessageConverter() {
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        return new MappingJackson2HttpMessageConverter();
    }


//    @Bean
//    public MappingJackson2HttpMessageConverter xssMappingJacksonHttpMessageConverter(){
//        return new XssMappingJacksonHttpMessageConverter();
//    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverter());
        converters.add(mappingJackson2HttpMessageConverter());
//        converters.add(xssMappingJacksonHttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

}
