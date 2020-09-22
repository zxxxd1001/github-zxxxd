package com.git.zxxxd.rocketmqapi.orderly;


import com.git.zxxxd.rocketmqapi.constants.Const;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.List;

public class Consumer {

    public static void main(String[] args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("test_orderly_consumer_name");
        consumer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.subscribe("test_orderly_topic", "*");

        consumer.registerMessageListener(new MessageListenerOrderly() {

            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {

                try {
                    for(MessageExt me:list){
                        String topic = me.getTopic();
                        String tags = me.getTags();
                        String keys = me.getKeys();
                        String msgBody = new String(me.getBody(), RemotingHelper.DEFAULT_CHARSET);
                        System.err.println("topic: " + topic + ",tags: " + tags + ", keys: " + keys + ",body: " + msgBody);
                        //业务处理
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
        System.err.println("consumer start...");
    }
}
