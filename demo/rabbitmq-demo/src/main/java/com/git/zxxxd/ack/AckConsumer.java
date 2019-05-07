package com.git.zxxxd.ack;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * http://www.cnblogs.com/piaolingzxh/p/5448927.html
 */
public class AckConsumer {
    public static void main(String[] args)  throws Exception{
        //建立socket连接
        Connection connection = ConnectionUtils.getConnection();

        /* 创建Channel，含有处理信息的大部分API */
        Channel channel = connection.createChannel();
        //声明一个Queue，用来获取消息。QUEUE_NAME需要与Producer端相同
        channel.queueDeclare("test-ack", false, false, false, null);

        //从队列中异步获取消息，DefaultConsumer会设置一个回调来缓存消息。
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)throws IOException {
                try {
                    String message = new String(body, "UTF-8");
                    System.out.println("SimpleConsumer消费者获取消息：" + message );
                    this.getChannel().basicAck(envelope.getDeliveryTag(),false);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    //deliveryTag:该消息的index
                    //multiple：是否批量.true:将一次性拒绝所有小于deliveryTag的消息。
                    //requeue：被拒绝的是否重新入队列
                    this.getChannel().basicNack(envelope.getDeliveryTag(), false, true);
                    //抛弃此条消息
//                    this.getChannel().basicNack(envelope.getDeliveryTag(), false, false);
//                    区别在于basicNack可以拒绝多条消息，而basicReject一次只能拒绝一条消息
//                    this.getChannel().basicReject(envelope.getDeliveryTag(),false);
                    //消息重入队列，requeue=true，发送给新的consumer，false发送给相同的consumer
//                    this.getChannel().basicRecover(true);
                }
            }
        };
        channel.basicConsume("test-ack", false, consumer);
    }
}
