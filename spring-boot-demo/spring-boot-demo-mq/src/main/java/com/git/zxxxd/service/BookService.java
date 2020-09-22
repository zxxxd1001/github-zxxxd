package com.git.zxxxd.service;

import com.git.zxxxd.bean.Book;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class BookService {

    @RabbitListener(queues = "zxxxd.news")
    public void receive(Book book, Channel channel, @Header(name = "amqp_deliveryTag") long deliveryTag,
                        @Header("amqp_redelivered") boolean redelivered, @Headers Map<String, Object> head){
        try {
            Thread.sleep(2000);
            System.out.println("receive收到消息："+book);
            System.out.println();
//            channel.basicAck(deliveryTag, false);
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
            //这一步千万不要忘记，不会会导致消息未确认，消息到达连接的qos之后便不能再接收新消息
            //一般重试肯定的有次数，这里简单的根据是否已经重发过来来决定重发。第二个参数表示是否重新分发
            try {
                channel.basicReject(deliveryTag, !redelivered);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            //这个方法我知道的是比上面多一个批量确认的参数
            // channel.basicNack(deliveryTag, false,!redelivered);
        }
//        head.keySet().stream().forEach(item->{
//            System.out.print(item+":");
//            System.out.print(head.get(item));
//            System.out.println();
//        });
    }
//    @RabbitListener(queues = "zxxxd.news")
    public void receive1(Book book,Channel channel,@Header(name = "amqp_deliveryTag") long deliveryTag){
        try {
            Thread.sleep(1000);
            System.out.println("receive1收到消息："+book);
            channel.basicAck(deliveryTag, false);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                channel.basicReject(deliveryTag, true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

//    @RabbitListener(queues = "zxxxd")
    public void receive02(Message message){
        System.out.println("receive02收到消息："+message.getBody());
        System.out.println("receive02收到消息："+message.getMessageProperties());
    }
}
