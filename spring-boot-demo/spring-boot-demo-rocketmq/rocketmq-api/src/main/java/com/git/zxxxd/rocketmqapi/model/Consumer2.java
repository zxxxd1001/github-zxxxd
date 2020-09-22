package com.git.zxxxd.rocketmqapi.model;

import com.git.zxxxd.rocketmqapi.constants.Const;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class Consumer2 {
    public static void main(String[] args) {
//        clustering();
        broadcasting();
        System.out.println("start...");
    }

    //集群模式consumerGroup一样天然自带负载均衡
    private static void clustering() {
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_model_consumer_name");
            consumer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);
            consumer.subscribe("test_model_topic1", "*");
            consumer.setMessageModel(MessageModel.CLUSTERING);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    try {
                        for (MessageExt msg : msgs) {
                            String topic = msg.getTopic();
                            String msgBody = new String(msg.getBody(), "utf-8");
                            String tags = msg.getTags();
                            //if(tags.equals("TagB")) {
                            System.out.println("收到消息：" + "  topic :" + topic + "  ,tags : " + tags + " ,msg : " + msgBody);
                            //}
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }

            });
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //广播模式
    private static void broadcasting() {
        try {
            DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_model_consumer_name");
            consumer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);
            consumer.subscribe("test_model_topic2", "*");
            consumer.setMessageModel(MessageModel.BROADCASTING);
            consumer.registerMessageListener(new MessageListenerConcurrently() {
                @Override
                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                    try {
                        for (MessageExt msg : msgs) {
                            String topic = msg.getTopic();
                            String msgBody = new String(msg.getBody(), "utf-8");
                            String tags = msg.getTags();
                            //if(tags.equals("TagB")) {
                            System.out.println("收到消息：" + "  topic :" + topic + "  ,tags : " + tags + " ,msg : " + msgBody);
                            //}
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }

            });
            consumer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
