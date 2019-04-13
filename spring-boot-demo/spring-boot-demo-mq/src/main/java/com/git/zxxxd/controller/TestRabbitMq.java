package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Book;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestRabbitMq {
    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 1、单播（点对点） 注意service
     */
    @GetMapping("send")
    public void send(){
        rabbitTemplate.convertAndSend("zxxxd.direct","zxxxd.emps",new Book("西游记","吴承恩"));
        rabbitTemplate.convertAndSend("zxxxd.direct","zxxxd.news",new Book("西游记","吴承恩"));
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        rabbitTemplate.convertAndSend("zxxxd.direct","zxxxd",map);
        rabbitTemplate.convertAndSend("zxxxd.topic","zxxxd",map);
    }
    /**
     * 广播
     */
    @GetMapping("send-fanout")
    public void sendFanout(){
        rabbitTemplate.convertAndSend("zxxxd.fanout","",new Book("红楼梦","曹雪芹"));
    }
    //接受数据,如何将数据自动的转为json发送出去
    @GetMapping("get-message")
    public String getMessage(){
        Object o = rabbitTemplate.receiveAndConvert("zxxxd.emps");
        System.out.println(o.getClass());
        System.out.println(o);
        return o.toString();
    }
}
