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
        factory.setHost("192.168.1.123");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("guest");
        factory.setPassword("guest");

        //自动恢复
//        factory.setAutomaticRecoveryEnabled(true);
        //网络超时重链
//        factory.setNetworkRecoveryInterval(3000);
        return factory.newConnection();
    }
}
