package com.git.zxxxd.rocketmqapi.tranactions;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

public class TransactionListenerImpl implements TransactionListener {
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        System.out.println("执行本地事物");
        String arg=(String) o;
        System.out.println("arg："+arg);
        System.out.println("message："+message);

        //数据库落库操作
        return LocalTransactionState.COMMIT_MESSAGE;
//        return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        System.out.println("回调消息检查");
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
