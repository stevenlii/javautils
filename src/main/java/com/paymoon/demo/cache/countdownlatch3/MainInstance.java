package com.paymoon.demo.cache.countdownlatch3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainInstance {
	private static ExecutorService service = Executors.newFixedThreadPool(10);
	private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 60*1000, TimeUnit.MILLISECONDS,
			new ArrayBlockingQueue<Runnable>(10));
	public static void main(String[] args) {
		int num = 5;
		executor.allowCoreThreadTimeOut(false);
		while (true) {
			CountDownLatch controller = new CountDownLatch(num);

			for (int i = 0; i < num; i++) {
				executor.execute(new Participant("P-" + i, controller));

			}
			try {
				controller.await();
				
				System.out.println("sleep done..."+executor.getActiveCount());
			} catch (InterruptedException e) {
			}

		}
	}
}