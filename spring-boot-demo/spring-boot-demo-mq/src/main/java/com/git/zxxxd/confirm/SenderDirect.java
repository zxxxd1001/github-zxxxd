package com.git.zxxxd.confirm;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SenderDirect implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    public void sendCallback(Object message) {
        rabbitTemplate.setConfirmCallback(this);
        CorrelationData correlationData = new CorrelationData("testPublisherConfirmsId");
        System.out.println("CallBackSender  UUID: " + correlationData.getId());

        this.rabbitTemplate.convertAndSend("zxxxd.direct","zxxxd.news" , message , correlationData);
    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
//        System.out.println("CallBackConfirm UUID: " + correlationData.getId());

        if(ack) {
            System.out.println("CallBackConfirm 消息消费成功！");
        }else {
            System.out.println("CallBackConfirm 消息消费失败！");
        }

        if(cause!=null) {
            System.out.println("CallBackConfirm Cause: " + cause);
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println(message.getMessageProperties().getCorrelationIdString() + " 发送失败");
    }
}
