package com.paymoon.demo.threadpool.test;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/**
 * Java线程：线程池-固定线程数的线程池
 */
public class Test2 {
    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Random random = new Random();
       while (true) {
		Thread t1 = new MyThread();
		t1.setName(String.valueOf(random.nextInt(100)));
		// 将线程放入池中进行执行
		pool.execute(t1);
		
       } 
        
    }
}

