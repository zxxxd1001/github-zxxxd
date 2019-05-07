package com.git.zxxxd.controller;

import com.git.zxxxd.bean.Book;
import com.git.zxxxd.confirm.SenderDirect;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.support.CorrelationData;
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

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    SenderDirect senderDirect;

    /**
     * 1、单播（点对点） 注意service
     */
    @GetMapping("send")
    public void send() {
        rabbitTemplate.convertAndSend("zxxxd.direct", "zxxxd.emps", new Book("西游记", "吴承恩"));
        rabbitTemplate.convertAndSend("zxxxd.direct", "zxxxd.news", new Book("西游记", "吴承恩"));
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        rabbitTemplate.convertAndSend("zxxxd.direct", "zxxxd", map);
        rabbitTemplate.convertAndSend("zxxxd.topic", "zxxxd", map);
    }

    /**
     * 广播
     */
    @GetMapping("send-fanout")
    public void sendFanout() {
        rabbitTemplate.convertAndSend("zxxxd.fanout", "", new Book("红楼梦", "曹雪芹"));
    }

    //接受数据,如何将数据自动的转为json发送出去
    @GetMapping("get-message")
    public String getMessage() {
        Object o = rabbitTemplate.receiveAndConvert("zxxxd.emps");
        System.out.println(o.getClass());
        System.out.println(o);
        return o.toString();
    }

    @GetMapping("test-publisher-confirms")
    public String testPublisherConfirms() {

//        rabbitTemplate.convertAndSend("zxxxd.direct", "zxxxd.news",
//                new Book("1", "2"),new CorrelationData("testPublisherConfirmsId"));
//        MessageProperties messageProperties = new MessageProperties();
//        //设置消息是否持久化。Persistent表示持久化，Non-persistent表示不持久化
//        messageProperties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
//        messageProperties.setContentType("UTF-8");
//
//        Message message = new Message("hello,rabbit_direct！".getBytes(), messageProperties);
        senderDirect.sendCallback(new Book("1", "2"));
        return "";
    }
}
