package com.git.zxxxd.rocketmqapi.quickstart;


import com.git.zxxxd.rocketmqapi.constants.Const;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.*;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;


public class Producer {
    public static void main(String[] args) throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
//        quickSend();
        send();
//        sendCall();
//        sendSchedule();
    }
    //同步发送消息
    private static void quickSend() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");

        producer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);

        producer.start();

        for (int i = 0; i < 5; i++) {
            //创建消息
            Message message = new Message("test_quick_topic",    //	主题
                    "quickSend", //	标签
                    "key" + i,    // 	用户自定义的key ,唯一的标识
                    ("Hello RocketMQ" + i).getBytes());    //	消息内容实体（byte[]）
            SendResult sr = producer.send(message);
            System.err.println("消息发出：" + sr.getSendStatus());
        }
        producer.shutdown();
    }

    //自定义投递规则
    private static void send() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");

        producer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);

        producer.start();

        for (int i = 0; i < 5; i++) {
            Message message = new Message("test_quick_topic", "send", "key" + i, ("send RocketMQ" + i).getBytes());
            //发送的指定的队列中去 2
            SendResult sr = producer.send(message, new MessageQueueSelector() {
                @Override
                public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                    Integer queueNumber = (Integer) arg;
                    return mqs.get(queueNumber);
                }
            }, 2);
            System.err.println(sr);
            System.err.println("消息发出: " + sr.getSendStatus());
        }
        producer.shutdown();
    }

    //异步发送消息
    private static void sendCall() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");

        producer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);

        producer.start();

        for (int i = 0; i < 5; i++) {
            //	1.	创建消息
            Message message = new Message("test_quick_topic", "sendCall", "key" + i, ("sendCall RocketMQ" + i).getBytes());

            producer.send(message, new SendCallback() {
                //rabbitmq急速入门的实战: 可靠性消息投递
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.err.println("msgId: " + sendResult.getMsgId() + ", status: " + sendResult.getSendStatus());
                }

                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                    System.err.println("------发送失败");
                }
            });
        }
    }

    //延时消息发送
    private static void sendSchedule() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test_quick_producer_name");

        producer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);

        producer.start();

        for (int i = 0; i < 5; i++) {
            Message message = new Message("test_quick_topic", "sendSchedule", "key" + i, ("sendSchedule RocketMQ" + i).getBytes());

            //设置延时时间
            if (i == 1) {
                message.setDelayTimeLevel(3);
            }

            SendResult sr = producer.send(message);
            System.err.println(sr);
            System.err.println("消息发出: " + sr.getSendStatus());
        }
        producer.shutdown();
    }

}
