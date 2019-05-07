package com.git.zxxxd.exchange;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class TopicExchange {
    public static void main(String[] args) throws Exception{
        TopicExchange t=new TopicExchange();
        t.consumer();
        t.consumer1();
    }
    private final static String TOPIC_EXCHANGE_NAME="test-exchange-topic";
    public void producer()throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        //指定Exchange的Type = "Topic"
        channel.exchangeDeclare(TopicExchange.TOPIC_EXCHANGE_NAME, "topic");

        String routingKey1 = "AAA.orange.BBB";
        String message1 = "Q1 infomations....";
        String routingKey2 = "lazy.orange.fox";
        String message2 = "Q1,Q2 infomations....";
        String routingKey3 = "lazy.brown.fox";
        String message3 = "Q2 infomations....";

        //指定消息的路由参数：routingKey，并发送消息
        channel.basicPublish(TopicExchange.TOPIC_EXCHANGE_NAME, routingKey1, null, message1.getBytes());
        channel.basicPublish(TopicExchange.TOPIC_EXCHANGE_NAME, routingKey2, null, message2.getBytes());
        channel.basicPublish(TopicExchange.TOPIC_EXCHANGE_NAME, routingKey3, null, message3.getBytes());

        //发布消息成功提示信息
        System.out.println("producer成功发送信息：" +  message1);
        System.out.println("producer成功发送信息：" +  message2);
        System.out.println("producer成功发送信息：" +  message3);

        //关闭连接
        channel.close();
        connection.close();
    }

    private void consumer() throws Exception{
        bindConsumer("consumer","*.orange.*");
    }
    private void consumer1() throws Exception{
        bindConsumer("consumer1","*.*.rabbit", "lazy.#");
    }
    private void bindConsumer(final String name,String... routingKeys)throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(TopicExchange.TOPIC_EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        String queueName = channel.queueDeclare().getQueue();
        for(String routingKey : routingKeys){
            channel.queueBind(queueName, TopicExchange.TOPIC_EXCHANGE_NAME,  routingKey);
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
