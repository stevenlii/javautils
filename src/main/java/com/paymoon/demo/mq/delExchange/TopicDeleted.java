package com.paymoon.demo.mq.delExchange;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.SerializationUtils;

import com.paymoon.demo.Util.MyProp;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class TopicDeleted {
	public TopicDeleted() {
	}
	public void delExchangeName(List<String> exchangeNames,List<String> QNames)
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
		} catch (TimeoutException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Channel channel = connection.createChannel();
//		channel.exchangeDeclare(exchangeName, "fanout");// 声明Exchange
//
//		channel.basicPublish(exchangeName, "", null,
//				SerializationUtils.serialize(object));
		for (String exchangeName : exchangeNames){ 
			channel.exchangeDelete(exchangeName);
			System.out.println("del..."+exchangeName);
		}
		for (String QName : QNames){ 
			channel.queueDelete(QName);
			System.out.println("delQ..."+QName);
		}
		
		try {
			channel.close();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    connection.close();  
	}
	public void delQ(List<String> Qs)
			throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		
		// hostname of your rabbitmq server
		String hostname = MyProp
				.getVariable("mq.host", "localhost");
		String username = MyProp.getVariable("mq.user","guest");
		String password = MyProp.getVariable("mq.password","guest");
		factory.setHost(hostname);
		factory.setUsername(username);
		factory.setPassword(password);
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
//		channel.exchangeDeclare(exchangeName, "fanout");// 声明Exchange
//
//		channel.basicPublish(exchangeName, "", null,
//				SerializationUtils.serialize(object));
		for (String q : Qs){ 
			channel.queueDelete(q);
			System.out.println("del..."+q);
		}
		
		channel.close();  
		connection.close();  
	}

}
