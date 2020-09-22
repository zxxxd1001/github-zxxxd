package com.git.zxxxd.rocketmqapi.tranactions;


import com.git.zxxxd.rocketmqapi.constants.Const;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class Consumer {

    public static void main(String[] args) throws MQClientException {

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("text_tx_consumer_group_name");
        consumer.setConsumeThreadMin(10);
        consumer.setConsumeThreadMax(20);
        consumer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);

        //consumeFromWhere Consumer 启动后，默认从什么位 置开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);

        //订阅关系  send中的tag过滤 比如：quickSend
        consumer.subscribe("test_tx_topic", "*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {

            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                MessageExt me = msgs.get(0);
                try {
                    String topic = me.getTopic();
                    String tags = me.getTags();
                    String keys = me.getKeys();
                    String msgBody = new String(me.getBody(), RemotingHelper.DEFAULT_CHARSET);
                    System.err.println("topic: " + topic + ",tags: " + tags + ", keys: " + keys + ",body: " + msgBody);
                } catch (Exception e) {
                    e.printStackTrace();
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.err.println("consumer start...");
    }
}
