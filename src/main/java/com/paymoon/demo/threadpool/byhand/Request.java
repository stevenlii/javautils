package com.paymoon.demo.threadpool.byhand;

import java.util.Random;

/**
 * 请求类
 * @author Administrator
 * 
 */
public class Request {
	
	/**
	 * 请求名称
	 */
	private final String name;
	
	private final Random random = new Random();
	
	public Request(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * 请求执行方法
	 */
	public void execute(){
		System.out.println(Thread.currentThread().getName()+" execute "+getName());
		try {
			Thread.sleep(random.nextInt(3000));//摸拟执行时间
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String toString(){
		return "{"+name+"}";
	}
	
	
}
