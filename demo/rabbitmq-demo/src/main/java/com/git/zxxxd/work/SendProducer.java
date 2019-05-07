package com.git.zxxxd.work;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

public class SendProducer {
    public void producer() throws Exception{
        // 创建一个连接
        Connection connection = ConnectionUtils.getConnection();
        // 创建一个频道
        Channel channel = connection.createChannel();
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        // 指定一个队列
        channel.queueDeclare("test-work", false, false, false, null);
        // 消息发送
        for (int i = 0; i < 50; i++) {
            String message = "hello " + i;

            System.out.println("生产者：" + message);

            channel.basicPublish("", "test-work", null, message.getBytes());
        }
        // 关闭频道和连接
        channel.close();
        connection.close();
    }
}
