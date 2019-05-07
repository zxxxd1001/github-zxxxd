package com.git.zxxxd;

import com.git.zxxxd.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoMqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    /**
     * 1、单播（点对点） 注意service
     */
    @Test
    public void contextLoads() {
//        Message需要自己构造一个;定义消息体内容和消息头
//        rabbitTemplate.send("zxxxd.direct","zxxxd.news", new Message(new byte[]{1,2,3,4,5,6,7},new MessageProperties()));

//        object默认当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq；
//        rabbitTemplate.convertAndSend(exchage,routeKey,object);
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("zxxxd.direct","zxxxd.emps",new Book("西游记","吴承恩"));
        rabbitTemplate.convertAndSend("zxxxd.direct","zxxxd.news",new Book("西游记","吴承恩"));
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        rabbitTemplate.convertAndSend("zxxxd.direct","zxxxd",map);
        rabbitTemplate.convertAndSend("zxxxd.topic","zxxxd",map);

    }

    //接受数据,如何将数据自动的转为json发送出去
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("zxxxd.emps");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("zxxxd.fanout","",new Book("红楼梦","曹雪芹"));
    }


    @Test
    public void addMessage(){
        for (int i=0;i<20;i++){
            rabbitTemplate.convertAndSend("zxxxd.fanout","",new Book("红楼梦"+i,"曹雪芹"+i));
        }
    }

}
