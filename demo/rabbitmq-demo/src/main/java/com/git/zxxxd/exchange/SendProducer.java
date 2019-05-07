package com.git.zxxxd.exchange;

public class SendProducer {
    public static void main(String[] args)throws Exception {
        FanoutExchange f=new FanoutExchange();
        f.producer();
        TopicExchange t=new TopicExchange();
        t.producer();
        DirectExchange d=new DirectExchange();
        d.producer();
    }
}
