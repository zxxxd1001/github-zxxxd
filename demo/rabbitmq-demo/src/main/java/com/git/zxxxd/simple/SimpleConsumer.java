package com.git.zxxxd.simple;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.UnsupportedEncodingException;

public class SimpleConsumer {
    public static void main(String[] args)  throws Exception{
        //建立socket连接
        Connection connection = ConnectionUtils.getConnection();

        /* 创建Channel，含有处理信息的大部分API */
        Channel channel = connection.createChannel();
        //声明一个Queue，用来获取消息。QUEUE_NAME需要与Producer端相同
        channel.queueDeclare("test-simple", false, false, false, null);

        //从队列中异步获取消息，DefaultConsumer会设置一个回调来缓存消息。
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) {
                String message = null;
                try {
                    message = new String(body, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                System.out.println("SimpleConsumer消费者获取消息：" + message );
            }
        };
        channel.basicConsume("test-simple", true, consumer);
    }
}
