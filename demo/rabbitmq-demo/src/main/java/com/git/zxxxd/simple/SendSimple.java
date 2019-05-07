package com.git.zxxxd.simple;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

public class SendSimple {
    public static void main(String[] args) throws Exception {
        Connection connection=ConnectionUtils.getConnection();
        //创建Channel，含有处理信息的大部分API
        Channel channel = connection.createChannel();
        //声明一个Queue，用来存放消息
        channel.queueDeclare("test-simple", false, false, false, null);
        //消息内容
        String message = "hello, little qute rabbitmq!";
        //发布消息
        channel.basicPublish("", "test-simple", null, message.getBytes());
        //发布消息成功提示信息
        System.out.println("SendSimple生产者成功发送信息：" +  message);

        //关闭连接
        channel.close();
        connection.close();
    }
}
