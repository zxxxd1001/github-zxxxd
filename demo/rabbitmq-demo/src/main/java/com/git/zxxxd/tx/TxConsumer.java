package com.git.zxxxd.tx;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class TxConsumer {
    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("test-queue-tx", true, false, false, null);
        channel.txSelect();

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" Received '" + envelope.getRoutingKey() + "':'" + message + "'");
                try {
                    /**
                     * 消费者处理时，发生异常消息
                     */
                    int i = 1  / 0;
                    this.getChannel().basicAck(envelope.getDeliveryTag(), false);
                    this.getChannel().txCommit();
                } catch (Exception e) {
                    e.printStackTrace();
                    this.getChannel().basicNack(envelope.getDeliveryTag(),false,false);
                    this.getChannel().txRollback();
                }
            }
        };
        //false手动应答
        channel.basicConsume("test-queue-tx", false, consumer);
    }
}
