package com.git.zxxxd.controller;

import com.git.zxxxd.myevent.MyEvent;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController implements ApplicationContextAware {
    @Autowired
    private ApplicationEventPublisher appEventPublisher;

    private ApplicationContext applicationContext;

    @GetMapping("hello")
    public Map<String, Object> hello() {
        Map<String, Object> mm = new HashMap<>();
        mm.put("userid","123123123");
        mm.put("userName","张三");
        Map<String, Object> m = new HashMap<>();
        m.put("instId", "304816");
        m.put("list",Arrays.asList(mm));
        return m;
    }

    @RequestMapping("test")
    public Map<String, Object> test(@RequestBody Map m) {
//        Map<String, Object> m = new HashMap<>();
        String json="{\n" +
                "    \"instId\": \"304816\",\n" +
                "    \"list\": [\n" +
                "        {\n" +
                "            \"userName\": \"张三\",\n" +
                "            \"userid\": \"123123123\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        m.put("json",json);
//        Integer i=1/0;
        try {
            // 将JSON字符串转换为JSONObject
            JSONObject jsonObject1 = new JSONObject(json);
            // 将JSONObject转换为XML字符串
            String json2xml = XML.toString(jsonObject1);
            m.put("json2xml", json2xml);

            // 将XML字符串转换为JSONObject
            JSONObject jsonObject = XML.toJSONObject(json2xml);
            // 将JSONObject转换为JSON字符串
            m.put("xml2json", jsonObject.toString());
            appEventPublisher.publishEvent(new MyEvent(m));
//            applicationContext.publishEvent(new MyEvent(m));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return m;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
