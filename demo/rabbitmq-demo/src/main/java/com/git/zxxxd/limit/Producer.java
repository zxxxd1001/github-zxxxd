package com.git.zxxxd.limit;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Producer {

	
	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		for(int i =0; i<5; i ++){
			channel.basicPublish("test_qos_exchange", "qos.save", true, null, "Hello RabbitMQ QOS Message".getBytes());
		}
	}
}
