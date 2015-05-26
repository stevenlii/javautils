package com.paymoon.demo.web.tcprpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

import org.apache.log4j.Logger;


public class Consumer {
	private static transient Logger logger = Logger
			.getLogger(Consumer.class);
	public static void main(String[] args) {
		String interfacename = SayHeloService.class.getName();
		
		try {
			Method method = SayHeloService.class.getMethod("sayHello", java.lang.String.class);
			Object[] arguments = {"hello"};
			Socket socket = new Socket("127.0.0.1",1234);
			 //trans method and argument to remote
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			output.writeUTF(interfacename);
			output.writeUnshared(method.getName());
			output.writeObject(method.getParameterTypes());
			output.writeObject(arguments);
			//get data form remote
			ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
			Object result = input.readObject();
		} catch (NoSuchMethodException | SecurityException e) {
			logger.info("method error");
			e.printStackTrace();
		} catch (UnknownHostException e) {
			logger.info("output error");
			e.printStackTrace();
		} catch (IOException e) {
			logger.info("output error");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.info("input error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
