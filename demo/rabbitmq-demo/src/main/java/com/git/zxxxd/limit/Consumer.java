package com.git.zxxxd.limit;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {

	
	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();

		String exchangeName = "test_qos_exchange";
		String queueName = "test_qos_queue";
		String routingKey = "qos.#";
		
		channel.exchangeDeclare(exchangeName, "topic", true, false, null);
		channel.queueDeclare(queueName, true, false, false, null);
		channel.queueBind(queueName, exchangeName, routingKey);
		
		//1 限流方式  第一件事就是 autoAck设置为 false
		channel.basicQos(0, 1, false);
		// 手工签收 必须要关闭 autoAck = false
		channel.basicConsume(queueName, false, new DefaultConsumer(channel){
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.err.println("-----------consume message----------");
				System.out.println("consumerTag: " + consumerTag);
				System.out.println("envelope: " + envelope);
				System.out.println("properties: " + properties);
				System.out.println("body: " + new String(body));

				getChannel().basicAck(envelope.getDeliveryTag(), false);

			}
		});
		
		
	}
}
