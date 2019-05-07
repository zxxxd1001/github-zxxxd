package com.git.zxxxd.exchange;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class DirectExchange {
    private final static String  EXCHANGE_NAME="test-exchange-direct";
    public static void main(String[] args) throws Exception {
        DirectExchange f=new DirectExchange();
        f.consumer();
        f.consumer1();
    }

    public void producer() throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(DirectExchange.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String routingKey1 = "error";
        String message1 = "error infomations....";
        String routingKey2 = "warning";
        String message2 = "warning infomations....";
        String routingKey3 = "info";
        String message3 = "info infomations....";

        //指定消息的路由参数：routingKey，并发送消息
        channel.basicPublish(EXCHANGE_NAME, routingKey1, null, message1.getBytes());
        channel.basicPublish(EXCHANGE_NAME, routingKey2, null, message2.getBytes());
        channel.basicPublish(EXCHANGE_NAME, routingKey3, null, message3.getBytes());

        //发布消息成功提示信息
        System.out.println("producer成功发送信息：" +  message1);
        System.out.println("producer成功发送信息：" +  message2);
        System.out.println("producer成功发送信息：" +  message3);

        //关闭连接
        channel.close();
        connection.close();
    }
    private void consumer() throws Exception{
        bindConsumer("consumer","error");
    }
    private void consumer1() throws Exception{
        bindConsumer("consumer1","error", "info", "warning");
    }
    private void bindConsumer(final String name,String... routingKeys)throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(DirectExchange.EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        String queueName = channel.queueDeclare().getQueue();
        for(String routingKey : routingKeys){
            channel.queueBind(queueName, DirectExchange.EXCHANGE_NAME,  routingKey);
        }

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(name+" Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
