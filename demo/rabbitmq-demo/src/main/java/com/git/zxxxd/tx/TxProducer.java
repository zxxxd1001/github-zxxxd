package com.git.zxxxd.tx;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;

import java.util.Date;


public class TxProducer {
    public static void main(String[] args)throws Exception {
        Connection connection = ConnectionUtils.getConnection();
        // 创建信道
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare("test-queue-tx", true, false, false, null);
        String message = String.format("时间 => %s", new Date().getTime());
        try {
            channel.txSelect(); // 声明事务
            /**
             * 发生错误时发送消息撤回
             */
            channel.basicPublish("", "test-queue-tx", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            channel.txCommit(); // 提交事务
            System.out.println("TxProducer txCommit");
        } catch (Exception e) {
            channel.txRollback();
            System.out.println("TxProducer txRollback");
        } finally {
            channel.close();
            connection.close();
        }
    }
}
