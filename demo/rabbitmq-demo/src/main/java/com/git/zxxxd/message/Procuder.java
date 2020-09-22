package com.git.zxxxd.message;

import java.util.HashMap;
import java.util.Map;

import com.git.zxxxd.common.ConnectionUtils;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Procuder {

	
	public static void main(String[] args) throws Exception {
		Connection connection = ConnectionUtils.getConnection();
		Channel channel = connection.createChannel();
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("my1", "111");
		headers.put("my2", "222");
		AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
				.deliveryMode(2)
				.contentEncoding("UTF-8")
				.expiration("10000")
				.headers(headers)
				.build();
		
		//4 通过Channel发送数据
		for(int i=0; i < 5; i++){
			String msg = "Hello RabbitMQ!";
			//1 exchange   2 routingKey
			channel.basicPublish("", "test001", properties, msg.getBytes());
		}

		//5 记得要关闭相关的连接
		channel.close();
		connection.close();
	}
}
