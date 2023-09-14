package com.git.zxxxd.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class SpringFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
//        RequestWrapper wrapper = new RequestWrapper(httpServletRequest);
//        String body=wrapper.getBody();

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(httpServletRequest);
        ContentCachingResponseWrapper responseWrapper=new ContentCachingResponseWrapper(httpServletResponse);
        chain.doFilter(requestWrapper,responseWrapper);
        String body = StreamUtils.copyToString(requestWrapper.getInputStream(), StandardCharsets.UTF_8);
        System.out.println("request_body: " + body);
        byte[] responseBody = responseWrapper.getContentAsByteArray();
        body = new String(responseBody, StandardCharsets.UTF_8);
        System.out.println("response_body: " + body);

        Map map = JSONObject.parseObject(body, Map.class);
        map.put("test", "t阿斯顿");
        responseWrapper.resetBuffer();
        String s = JSON.toJSONString(map);
        System.out.println(s);
        responseWrapper.setCharacterEncoding(StandardCharsets.UTF_8.name());
        responseWrapper.getWriter().write(s);
        //将缓存的响应内容写回原始响应
        responseWrapper.copyBodyToResponse();


//        chain.doFilter(new ContentCachingRequestWrapper(httpServletRequest), response);
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
