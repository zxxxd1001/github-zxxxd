package com.git.zxxxd.service;

import com.git.zxxxd.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues = "zxxxd.news")
    public void receive(Book book){
        System.out.println("receive收到消息："+book);
    }

    @RabbitListener(queues = "zxxxd")
    public void receive02(Message message){
        System.out.println("receive02收到消息："+message.getBody());
        System.out.println("receive02收到消息："+message.getMessageProperties());
    }
}
