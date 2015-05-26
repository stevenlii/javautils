package com.paymoon.demo.web.tcprpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

public class Provider {
	private static transient Logger logger = Logger.getLogger(Provider.class);

	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(1234);
			while(true){
				Socket socket = server.accept();
				ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
				String interfacename = input.readUTF();
				String methodname = input.readUTF();
				Class<?>[] parameterTypes = (Class<?>[])input.readObject();
				Object[] argumentsObjects = (Object[])input.readObject();
				
				//execute
				Class serviceinterfaceclassClass = Class.forName(interfacename);
//				Object service = services.get(interfacename);
				//services.get(interfacename); should be overwrite
				//查找项目中实现接口的所有类 - i2534 - ITeye技术网站
				//http://i2534.iteye.com/blog/811684
				//Commons ClassScan - User guide
				//http://commons.apache.org/sandbox/commons-classscan/userguide.html
				Object service = interfacename;
				Method method = serviceinterfaceclassClass.getMethod(methodname, parameterTypes);
				Object result = method.invoke(service, argumentsObjects);
				ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
				output.writeObject(result);
				
			}
		} catch (IOException e) {
			logger.info("server error");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.info("input Class");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
