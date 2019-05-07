package com.git.zxxxd.work;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class WorkConsumer {
    public void consumer(final String str, final long time, final Boolean model) throws Exception {
        // 打开连接和创建频道，与发送端一样
        Connection connection = ConnectionUtils.getConnection();
        final Channel channel = connection.createChannel();

        // 声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare("test-work", false, false, false, null);

//        每个消费者发送确认消息之前，消息队列不发送下一个消息到消费者，一次只处理一个消息。 限制发送给同一个消费者不得超过1条消息。
        if (!model) {
            int prefetchCount = 1;
            channel.basicQos(prefetchCount);
        }

        // 定义一个消费者监听消息
        Consumer consumer = new DefaultConsumer(channel) {
            // 一旦有消息，触发该方法
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");

                System.out.println(str + "：" + message);

                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    System.out.println(str+"：" + "Done");
                    if (!model) {
//                        业务处理完成，手动ack
                        channel.basicAck(envelope.getDeliveryTag(), model);
                    }
                }
            }
        };

        boolean autoAck = model;// 手动应答 false
        channel.basicConsume("test-work", autoAck, consumer);

        // 让程序处于运行状态，让消费者监听消息
        Thread.sleep(1000 * 60);
    }
}
