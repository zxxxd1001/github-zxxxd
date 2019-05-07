package com.git.zxxxd.confirm;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfirmConsumer {
    public static void main(String[] args) throws Exception {
        ConfirmConsumer c = new ConfirmConsumer();
//        c.consumer();
        c.consumer2();
    }

    public void consumer2() throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-max-length", 10);
        channel.queueDeclare("test-listener-confirm", false, false, false, args);
        channel.basicConsume("test-listener-confirm", false, new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" Received '" + envelope.getRoutingKey() + "':'" + message + "'");
                getChannel().basicAck(envelope.getDeliveryTag(), false);
            }
        });
    }

    public void consumer() throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        //开启transaction机制
        channel.confirmSelect();
        //autoDelete,true只要被消息
        channel.queueDeclare("test-easy-confirm", false, false, false, null);
        channel.basicConsume("test-easy-confirm", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        });
    }
}
