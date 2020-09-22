package com.git.zxxxd.quickstart.dlx;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

public class Consumer {


    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        // 这就是一个普通的交换机 和 队列 以及路由
        String exchangeName = "test_dlx_exchange";
        String routingKey = "dlx.#";
        String queueName = "test_dlx_queue";

        channel.exchangeDeclare(exchangeName, "topic", true, false, null);

        Map<String, Object> agruments = new HashMap<String, Object>();
        agruments.put("x-dead-letter-exchange", "dlx.exchange");
        //这个agruments属性，要设置到声明队列上
        channel.queueDeclare(queueName, true, false, false, agruments);
        channel.queueBind(queueName, exchangeName, routingKey);

        //要进行死信队列的声明:
        channel.exchangeDeclare("dlx.exchange", "topic", true, false, null);
        channel.queueDeclare("dlx.queue", true, false, false, null);
        channel.queueBind("dlx.queue", "dlx.exchange", "#");

        channel.basicConsume(queueName, true, new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws
                    IOException {
                System.err.println("-----------consume message----------");
                System.out.println("consumerTag: " + consumerTag);
                System.out.println("envelope: " + envelope);
                System.out.println("properties: " + properties);
                System.out.println("body: " + new String(body));
            }
        });

    }
}
