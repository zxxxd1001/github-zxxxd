package com.git.zxxxd.returnlistener;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Consumer {

	
	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		String exchangeName = "test_return_exchange";
		String routingKey = "return.#";
		String queueName = "test_return_queue";
		channel.exchangeDeclare(exchangeName, "topic", true, false, null);
		channel.queueDeclare(queueName, true, false, false, null);
		channel.queueBind(queueName, exchangeName, routingKey);
		channel.basicConsume(queueName, true, new DefaultConsumer(channel){
			public void handleDelivery(String consumerTag, Envelope envelope,
									   AMQP.BasicProperties properties, byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.err.println("消费端: " + message);
			}
		});

	}
}
