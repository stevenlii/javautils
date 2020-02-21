package com.paymoon.demo.mq.produce;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.SerializationUtils;

import com.paymoon.demo.Util.MyProp;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicProducer {
	public TopicProducer() {
	}
	public void sendMessage(String exchangeName, Serializable object)
			throws IOException {
		ConnectionFactory factory = new ConnectionFactory();

		// hostname of your rabbitmq server
		String hostname = MyProp
				.getVariable("mq.host", "localhost");
		String username = MyProp.getVariable("mq.user","guest");
		String password = MyProp.getVariable("mq.password","guest");
		factory.setHost(hostname);
		factory.setUsername(username);
		factory.setPassword(password);
		Connection connection = null;
		try {
			connection = factory.newConnection();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Channel channel = connection.createChannel();
		channel.exchangeDeclare(exchangeName, "fanout");// 声明Exchange

		channel.basicPublish(exchangeName, "", null,
				SerializationUtils.serialize(object));
		
		try {
			channel.close();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    connection.close();  
	}

}
