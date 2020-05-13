package com.paymoon.demo.threadpool.productconsumer;

import java.util.LinkedList;

/**
 * 请求队列类
 * @author Administrator
 *
 */
public class RequestQueue {
	
        //存储请求列表
	private LinkedList<Request> requests = new LinkedList<Request>();
	//请求列表大小
	private int size;
	
	public RequestQueue(int size){
		this.size = size;
	};
	
	/**
	 * 添加请求
	 * @param request
	 */
	public synchronized void putRequest(Request request){
		
		while(requests.size() > size){//判断请求队列中是否达到队列容量
			try {
				System.out.println(Thread.currentThread().getName()+" {putRequest wait}");
				wait();//添加线程等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		requests.addLast(request);//添加请求
		System.out.println(Thread.currentThread().getName()+" putRequest "+request);
		notifyAll();//唤醒其他等待线程
	};
	
	
	/**
	 * 获取请求
	 * @return
	 */
	public synchronized Request getRequest(){
		
		while(requests.size() <= 0){//判断是否队列中是否存在请求
			try {
				System.out.println(Thread.currentThread().getName()+" {getRequest wait}");
				wait();//消费线程等待
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Request request = requests.removeFirst();//取出请求
		System.out.println(Thread.currentThread().getName()+" getRequest "+request);
		notifyAll();//唤醒其他线程
		return request;
	};
	
	
}