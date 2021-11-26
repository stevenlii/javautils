package com.paymoon.demo.Ztest;
 
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
/**
 * 
 * @author stevenlii
 * 
 * CyclicBarrier:一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。
 * 	在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。
 * 因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。
	CyclicBarrier可以多次重复使用
 */
public class CyclicBarrierTest_RelayRace {
 
	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService exec = Executors.newCachedThreadPool();
		
		final CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
 
			@Override
			public void run() {
				System.out.println("上一步全部完成，进入下一步……"  );
			}
		});		
		
		System.out.println("王者荣耀随机单排开始");				
		
		for (int i = 0; i < 5; i++) {
			exec.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + ":进入选英雄界面...");
					try {
						barrier.await();
						Thread.sleep((long) (2000 * Math.random()));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName() + ":选完英雄，进入加载...");
					try {
						barrier.await();
						Thread.sleep((long) (2000 * Math.random()));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+ ":加载到100%");
					try {
						barrier.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						e.printStackTrace();
					}
					
					System.out.println("欢迎"+Thread.currentThread().getName()+ " 来到王者荣耀，敌军还有30秒到达战场，全军出击！");
 
				}
			});
 
		}
		exec.shutdown();
				
	}
	
	
 
}
 