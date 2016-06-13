package com.paymoon.demo.threadpool.test;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;

/**
 * Java线程：线程池-固定线程数的线程池
 * https://www.ibm.com/developerworks/cn/java/j-lo-taskschedule/
 */
public class Test3 {
    public static void main(String[] args) {
    	long initialDelay1 = 0;
		long period1 = 1;
		Random random = new Random();
		
        // 创建一个可重用固定线程数的线程池
    	ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        int i = 10;
       while (i-->0) {
		Thread t1 = new MyThread();
		t1.setName(String.valueOf(i));
		// 将线程放入池中进行执行
		 // 从现在开始1秒钟之后，每隔1秒钟执行一次job1
		pool.scheduleAtFixedRate(
				t1, initialDelay1,
				random.nextInt(10), TimeUnit.SECONDS);

       } 
       System.out.println("--------------------------------------");
        
    }
}

