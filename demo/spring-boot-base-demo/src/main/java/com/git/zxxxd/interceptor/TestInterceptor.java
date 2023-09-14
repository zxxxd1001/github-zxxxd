package com.git.zxxxd.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class TestInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        System.out.println(httpServletRequest.getServletPath());

//        String requestBody = getRequestBody(httpServletRequest);
//        System.out.println("Request Body: " +requestBody);

//        RequestWrapper wrapper =(RequestWrapper)httpServletRequest;
//        String body=wrapper.getBody();
//        System.out.println("request_body: " + body);

        HandlerMethod h=(HandlerMethod)o;
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
//        ContentCachingRequestWrapper requestWrapper=(ContentCachingRequestWrapper)httpServletRequest;
//        // Get the cached request body as a byte array
//        byte[] requestBody = requestWrapper.getContentAsByteArray();
//
//        // Convert the byte array to a String (assuming it's UTF-8 encoded)
//        String requestBodyString = new String(requestBody, requestWrapper.getCharacterEncoding());
//
//        // Now you can use 'requestBodyString' to access the request body value
//        System.out.println("Request Body: " + requestBodyString);
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");

    }

    private String getRequestBody(HttpServletRequest request) throws IOException {
        StringBuilder requestBody = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            requestBody.append(line);
        }
        return requestBody.toString();
    }
}

