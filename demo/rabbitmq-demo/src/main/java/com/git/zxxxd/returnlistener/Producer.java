package com.git.zxxxd.returnlistener;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Producer {

	
	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		String exchange = "test_return_exchange";
		String routingKey = "return.save";
		String routingKeyError = "abc.save";
		String msg = "Hello RabbitMQ Return Message";
		channel.addReturnListener(new ReturnListener() {
			public void handleReturn(int replyCode, String replyText, String exchange,
                                     String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
				System.err.println("---------handle  return----------");
				System.err.println("replyCode: " + replyCode);
				System.err.println("replyText: " + replyText);
				System.err.println("exchange: " + exchange);
				System.err.println("routingKey: " + routingKey);
				System.err.println("properties: " + properties);
				System.err.println("body: " + new String(body));
			}
		});

		channel.basicPublish(exchange, routingKey, true, null, msg.getBytes());
		channel.basicPublish(exchange, routingKeyError, true, null, msg.getBytes());
	}
}
