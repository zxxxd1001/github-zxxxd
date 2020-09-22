package com.git.zxxxd.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyAMQPConfig {

//    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    /**
     * 未了解决什么问题：
     *      Only one ConfirmCallback is supported by each RabbitTemplate
     *
     * 异常信息解析：
     *      从异常信息字面意思来看，就是说每个RabbitTemplate对象只支持一个ConfirmCallback手动签收方式的回调，
     *      然后我谷歌在文档上面找到一个方法。
     *
     * 问题的解决：
     *      由于spring的Bean默认都是单例的，这个RabbitTemplate也不例外，
     *      既然每个RabbitTemplate对sa象只支持一个回调，
     *      那我就在该Bean放入spring容器把该RabbitTemplate
     *      设置为原型的(也就是@Scope=“prototype”),具体代码如下
     */
    @Bean
    @Scope("prototype")
    public RabbitTemplate rabbitTemplate(org.springframework.amqp.rabbit.connection.ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }
//    @Bean
//    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        return factory;
//    }
}
