package com.paymoon.demo.threadpool.byhand;

import java.util.Random;

/**
 * 客户端线程类
 * @author Administrator
 *
 */
public class ClientThread extends Thread{
	
	//请求队列
	private RequestQueue requestQueue;
	private Random random = new Random();
	
	public ClientThread(String name, RequestQueue queue){
		super(name);
		this.requestQueue = queue;
	}
	
	/**
	 * 循环产生请求
	 */
	public void run(){
		int count = 0;
		while(true){
			Request request = new Request("request."+count+"."+this.getName());
			requestQueue.putRequest(request);//添加请求
			count++;
			try {
				Thread.sleep(random.nextInt(1000));//随机休息
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
