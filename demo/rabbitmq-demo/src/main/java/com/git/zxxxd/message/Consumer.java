package com.git.zxxxd.message;

import java.io.IOException;
import java.util.Map;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

public class Consumer {

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        //4 声明（创建）一个队列
        String queueName = "test001";
        channel.queueDeclare(queueName, true, false, false, null);

        //6 设置Channel
        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body);
                System.err.println("消费端: " + msg);
                Map<String, Object> headers = properties.getHeaders();
                System.err.println("headers get my1 value: " + headers.get("my1"));
            }
        });
    }
}
