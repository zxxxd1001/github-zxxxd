package com.git.zxxxd.rocketmqapi.tranactions;

import com.git.zxxxd.rocketmqapi.constants.Const;
import io.micrometer.core.instrument.util.TimeUtils;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

import java.util.concurrent.*;

public class TranactionProducer {
    public static void main(String[] args) throws Exception{
        TransactionMQProducer transactionMQProducer=new TransactionMQProducer("text_tx_producer_group_name");
        ExecutorService executorService=
                new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(20), new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread t=new Thread(r);
                        t.setName("text_tx_producer_group_name-check-thread");
                        return t;
                    }
                });
        transactionMQProducer.setNamesrvAddr(Const.NAMESRV_ADDR_SINGLE);
        transactionMQProducer.setExecutorService(executorService);
        //这个对象主要做两件事情， 第一件事情就是异步执行本地事物，第二件事情就是回查
        TransactionListenerImpl transactionListener = new TransactionListenerImpl();
        transactionMQProducer.setTransactionListener(transactionListener);
        transactionMQProducer.start();

        Message message = new Message("test_tx_topic", "tx", "key", ("tx RocketMQ").getBytes(RemotingHelper.DEFAULT_CHARSET));
        transactionMQProducer.sendMessageInTransaction(message, "我是回调参数");
        Thread.sleep(Integer.MAX_VALUE);
    }
}
