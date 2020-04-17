package com.paymoon.demo.threadpool.productconsumer;

/**
 * 服务端线程类
 * @author Administrator
 *
 */
public class ServerThread  extends  Thread{
	
	//请求队列
	private RequestQueue requestQueue;
	
	public ServerThread(String name, RequestQueue requestQueue){
		super(name);
		this.requestQueue = requestQueue;
	}

	/**
	 * 获取请求处理请求
	 */
	public void run (){
		while (true) {
			Request request = requestQueue.getRequest();//获取队列中的请求
			request.execute();//执行请求方法
		}
	}
	
	
}
