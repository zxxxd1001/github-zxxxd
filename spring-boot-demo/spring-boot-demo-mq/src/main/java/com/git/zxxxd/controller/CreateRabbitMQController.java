package com.git.zxxxd.controller;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rabbitmq")
public class CreateRabbitMQController {
    @Autowired
    AmqpAdmin amqpAdmin;

    @GetMapping("create")
    public void createRabbitMQ(){

        amqpAdmin.declareExchange(new DirectExchange("zxxxd.direct"));
        amqpAdmin.declareExchange(new FanoutExchange("zxxxd.fanout"));
        amqpAdmin.declareExchange(new TopicExchange("zxxxd.topic"));

        amqpAdmin.declareQueue(new Queue("zxxxd",true));
        amqpAdmin.declareQueue(new Queue("com.news",true));
        amqpAdmin.declareQueue(new Queue("zxxxd.news",true));
        amqpAdmin.declareQueue(new Queue("zxxxd.emps",true));
//		创建绑定规则
        amqpAdmin.declareBinding(new Binding("zxxxd", Binding.DestinationType.QUEUE,"zxxxd.direct","zxxxd",null));
        amqpAdmin.declareBinding(new Binding("zxxxd.news", Binding.DestinationType.QUEUE,"zxxxd.direct","zxxxd.news",null));
        amqpAdmin.declareBinding(new Binding("zxxxd.emps", Binding.DestinationType.QUEUE,"zxxxd.direct","zxxxd.emps",null));
        amqpAdmin.declareBinding(new Binding("com.news", Binding.DestinationType.QUEUE,"zxxxd.direct","com.news",null));

        amqpAdmin.declareBinding(new Binding("zxxxd", Binding.DestinationType.QUEUE,"zxxxd.fanout","zxxxd",null));
        amqpAdmin.declareBinding(new Binding("zxxxd.news", Binding.DestinationType.QUEUE,"zxxxd.fanout","zxxxd.news",null));
        amqpAdmin.declareBinding(new Binding("zxxxd.emps", Binding.DestinationType.QUEUE,"zxxxd.fanout","zxxxd.emps",null));
        amqpAdmin.declareBinding(new Binding("com.news", Binding.DestinationType.QUEUE,"zxxxd.fanout","com.news",null));

        amqpAdmin.declareBinding(new Binding("zxxxd", Binding.DestinationType.QUEUE,"zxxxd.topic","zxxxd.#",null));
        amqpAdmin.declareBinding(new Binding("zxxxd.news", Binding.DestinationType.QUEUE,"zxxxd.topic","*.news",null));
        amqpAdmin.declareBinding(new Binding("zxxxd.emps", Binding.DestinationType.QUEUE,"zxxxd.topic","zxxxd.#",null));
        amqpAdmin.declareBinding(new Binding("com.news", Binding.DestinationType.QUEUE,"zxxxd.topic","*.news",null));

//		删除配置
        amqpAdmin.deleteQueue("zxxxd.queue");
        amqpAdmin.removeBinding(new Binding("zxxxd.queue", Binding.DestinationType.QUEUE,"zxxxd.exchange","amqp.haha",null));
        amqpAdmin.deleteExchange("zxxxd.exchange");
    }
}
