package com.paymoon.demo.threadpool.productconsumer;

/**
 * 服务端线程池
 * @author Administrator
 *
 */
public class ServerThreadPool {

	//存储线程数组
	private ServerThread[] serverThreads;
	//请求队列
	private RequestQueue requestQueue;
	
	/**
	 * 线程池构造方法
	 * @param queue 队列
	 * @param size 线程池大小
	 */
	public ServerThreadPool(RequestQueue queue, int size) {
		this.requestQueue = queue;
		//初始化线程池
		this.serverThreads = new ServerThread[size];
		for (int i = 0; i < size; i++) {
			serverThreads[i] = new ServerThread("ServerThread."+i, requestQueue);
		}
	}
	
	/**
	 * 循环启动线程池中的线程
	 */
	public void start(){
		for (int i = 0; i < serverThreads.length; i++) {
			serverThreads[i].start();
		}
	}
	
	
	
}
