package com.paymoon.demo.mq.consumer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.Util.MyProp;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

public class TopicConsumer implements Runnable, Consumer {
	protected Channel channel;
	protected Connection connection;
	protected String exchangeName;
	protected String queueName;
	Logger logger = org.apache.logging.log4j.LogManager.getLogger(this.getClass());
	public TopicConsumer(){}
	public TopicConsumer(String exchangeName,String queueName){
		this.init(exchangeName, queueName);
	}
	public void init(String exchangeName,String queueName){
		this.exchangeName=exchangeName;
		this.queueName=queueName;
		try{
			ConnectionFactory factory = new ConnectionFactory();

			// hostname of your rabbitmq server
			String hostname = MyProp
					.getVariable("mq.host", "139.129.35.61");//139.129.35.61//115.29.137.93
			String username = MyProp.getVariable("mq.user","guest");
			String password = MyProp.getVariable("mq.password","Upy0o123");
			System.out.println(hostname +">"+ username+">"+password);
			factory.setHost(hostname);
			factory.setUsername(username);
			factory.setPassword(password);

			// getting a connection
			Connection connection = factory.newConnection();

			// creating a channel
			channel = connection.createChannel();
			
			channel.exchangeDeclare(exchangeName, "fanout");
			channel.queueDeclare(queueName, false, false, false, null);  
	        channel.queueBind(queueName, exchangeName, "");//把Queue、Exchange绑定  
			// start consuming messages. Auto acknowledge messages.
		}catch(Exception e){
			logger.error(e);
		}
	}
	@Override
	public void handleCancel(String arg0) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCancelOk(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleConsumeOk(String consumerTag) {
		System.out.println("Consumer "+consumerTag +" registered");    

	}

	@Override
	public void handleDelivery(String consumerTag, Envelope env,
            BasicProperties props, byte[] body) throws IOException {
		// TODO Auto-generated method stub
		 Map map = (HashMap)SerializationUtils.deserialize(body);
		 try{
		 consumerMessage(map);
		 }catch(Exception e){
			 logger.error(e);
		 }
	}

	public void consumerMessage(Map map){
		if(map==null)
			 return;
		 Iterator it=map.keySet().iterator();
		 while(it.hasNext()){
			 Object key=it.next();
			 Object value=map.get(key);
			 logger.info("key {}, value {}",key,value);
		 }
	}
	@Override
	public void handleRecoverOk(String arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleShutdownSignal(String arg0, ShutdownSignalException arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			channel.basicConsume(queueName, true, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
