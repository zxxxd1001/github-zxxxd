package com.git.zxxxd.common;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtils {
    /**
     * 获取mq链接
     * @return
     */
    public static Connection getConnection() throws Exception{
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("10.3.37.176");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory.newConnection();
    }
}
