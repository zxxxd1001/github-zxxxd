package com.git.zxxxd.controller;

import com.git.zxxxd.bean.shop.QueryModel;
import com.git.zxxxd.service.ESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("es")
public class ESController {
    @Autowired
    private ESService esService;

    @PostMapping("analyze")
    public Map<String, Object> getAnalyze(String keyword)throws  Exception{
        return  esService.getAnalyze(keyword);
    }
    @GetMapping("hello")
    public String hello()throws  Exception{
        return "hello";
    }
    @GetMapping("test")
    public String test()throws  Exception{
        return esService.test();
    }


    /**
     *     @GetMapping("es")
     *     get请求报错 tomcat 问题没时间解决
     *
     *     java.lang.IllegalArgumentException: Invalid character found in the request target [/es/es/1?keyword=-0x87]. The valid characters are defined in RFC 7230 and RFC 3986
     *          at org.apache.coyote.http11.Http11InputBuffer.parseRequestLine(Http11InputBuffer.java:491) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
     *          at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:260) ~[tomcat-embed-core-9.0.37.jar:9.0.37]
     *          at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) [tomcat-embed-core-9.0.37.jar:9.0.37]
     *          at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868) [tomcat-embed-core-9.0.37.jar:9.0.37]
     *          at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1589) [tomcat-embed-core-9.0.37.jar:9.0.37]
     *          at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) [tomcat-embed-core-9.0.37.jar:9.0.37]
     *          at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142) [na:1.8.0_111]
     *          at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617) [na:1.8.0_111]
     *          at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) [tomcat-embed-core-9.0.37.jar:9.0.37]
     *          at java.lang.Thread.run(Thread.java:745) [na:1.8.0_111]
     */

    @PostMapping("es")
    public Map<String, Object> searchES(String keyword)throws IOException {
        return  esService.searchES(keyword);
    }

    @PostMapping("shop")
    public Map<String, Object> getShop(@RequestBody QueryModel map)throws  Exception{
        return  esService.getShop(map.getLongitude(),map.getLatitude(),map.getKeyword(),map.getOrderby(),map.getCategoryId(),map.getTags());
    }
}