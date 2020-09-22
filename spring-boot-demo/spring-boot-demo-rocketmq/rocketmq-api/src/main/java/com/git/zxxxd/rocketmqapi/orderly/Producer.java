package com.git.zxxxd.rocketmqapi.orderly;


import com.git.zxxxd.rocketmqapi.constants.Const;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");

        producer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);

        producer.start();

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-HH-dd HH:mm:ss");

        String s = simpleDateFormat.format(date);

        //这五条消息是一个大的业务操作
        for (int i = 0; i < 5; i++) {
            //时间戳
            String body = s + "hello orderly" + i;
            Message message = new Message("test_orderly_topic", "orderly", "key" + i, body.getBytes());
            //1是队列下标，如果使用顺序消息消费，必须实现MessageQueueSelector，保证消息进入同一个队列中去。
            SendResult sr = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Integer id = (Integer) o;
                    System.out.println("Integer：" + id);
                    return list.get(id);
                }
            }, 1);
            System.err.println("消息发出：" + sr);
        }

        //这五条消息是一个大的业务操作
        for (int i = 0; i < 5; i++) {
            //时间戳
            String body = s + "hello orderly" + i;
            Message message = new Message("test_orderly_topic", "orderly", "key" + i, body.getBytes());
            //1是队列下标，如果使用顺序消息消费，必须实现MessageQueueSelector，保证消息进入同一个队列中去。
            SendResult sr = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Integer id = (Integer) o;
                    System.out.println("Integer：" + id);
                    return list.get(id);
                }
            }, 2);
            System.err.println("消息发出：" + sr);
        }
        //这五条消息是一个大的业务操作
        for (int i = 0; i < 5; i++) {
            //时间戳
            String body = s + "hello orderly" + i;
            Message message = new Message("test_orderly_topic", "orderly", "key" + i, body.getBytes());
            //1是队列下标，如果使用顺序消息消费，必须实现MessageQueueSelector，保证消息进入同一个队列中去。
            SendResult sr = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Integer id = (Integer) o;
                    System.out.println("Integer：" + id);
                    return list.get(id);
                }
            }, 3);
            System.err.println("消息发出：" + sr);
        }

        producer.shutdown();
    }
}
