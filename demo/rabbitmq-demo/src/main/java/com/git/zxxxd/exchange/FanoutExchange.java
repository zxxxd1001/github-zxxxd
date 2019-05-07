package com.git.zxxxd.exchange;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class FanoutExchange {
    private final static String  EXCHANGE_NAME="test-exchange-fanout";
    public static void main(String[] args) throws Exception {
        FanoutExchange f=new FanoutExchange();
        f.consumer();
        f.consumer1();
    }

    public void producer() throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(FanoutExchange.EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        String message = "This message is from Fanout mode.特点是Consumer均可获取到消息";
        channel.basicPublish("test-exchange-fanout", "", null, message.getBytes());

        System.out.println("---【Producer发送消息】" + message + "---" );

        channel.close();
        connection.close();
    }

    private void consumer() throws Exception{
        bindConsumer("consumer");
    }
    private void consumer1() throws Exception{
        bindConsumer("consumer1");
    }

    private static void bindConsumer(final String name)throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(FanoutExchange.EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
        //获取Queue随机名
        String queueName = channel.queueDeclare().getQueue();
        //Binding:绑定Queue与Exchange，此处没有binding key。
        channel.queueBind(queueName, FanoutExchange.EXCHANGE_NAME, "");

        Consumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(name+"接收消息'" + message + "'");
            }
        };

        channel.basicConsume(queueName, true, consumer);
    }
}
