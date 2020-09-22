package com.git.zxxxd.ack;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.util.HashMap;
import java.util.Map;

public class SendProducer {
    public static void main(String[] args) throws Exception {
        Connection connection=ConnectionUtils.getConnection();
        //创建Channel，含有处理信息的大部分API
        Channel channel = connection.createChannel();
//        producer(channel);
        producer1(channel);
    }
    private static void producer(Channel channel)throws Exception{
        //声明一个Queue，用来存放消息
        channel.queueDeclare("test-ack", false, false, false, null);
        //消息内容
        String message = "hello, little qute rabbitmq!";
        //发布消息
        channel.basicPublish("", "test-ack", null, message.getBytes());
        //发布消息成功提示信息
        System.out.println("SendProducer生产者成功发送信息：" +  message);
    }
    private static void producer1(Channel channel)throws Exception{
        String exchange = "test_ack_exchange";
        String routingKey = "ack.save";
        for(int i =0; i<5; i ++){

            Map<String, Object> headers = new HashMap<String, Object>();
            headers.put("num", i);

            AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
                    .deliveryMode(2)
                    .contentEncoding("UTF-8")
                    .headers(headers)
                    .build();
            String msg = "Hello RabbitMQ ACK Message " + i;
            channel.basicPublish(exchange, routingKey, true, properties, msg.getBytes());
        }
    }
}
