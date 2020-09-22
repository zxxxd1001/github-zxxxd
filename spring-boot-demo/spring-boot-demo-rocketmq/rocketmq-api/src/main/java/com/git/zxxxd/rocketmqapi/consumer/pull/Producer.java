package com.git.zxxxd.rocketmqapi.consumer.pull;

import com.git.zxxxd.rocketmqapi.constants.Const;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

public class Producer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("test_pull_producer_name");
        producer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);
        producer.start();
        for (int i = 0; i < 10; i++) {
            try {
                Message msg = new Message("test_pull_topic", "TagA", ("Hello RocketMQ " + i).getBytes());

                SendResult sendResult = producer.send(msg);
                System.out.println(sendResult);
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(3000);
            }
        }

        producer.shutdown();
    }
}
