package com.paymoon.demo.threadpool.productconsumer2;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端线程类
 * 
 * @author Administrator
 *
 */
public class ClientThread3ChangeThreadSize {
	private static final Logger logger = LoggerFactory.getLogger(ClientThread3ChangeThreadSize.class);

	private ThreadPoolExecutor calculateThreadPool = null;
	BlockingQueue<Runnable> threadQueue = null;

	public void initCostInventoryThreadPoolService() {
		System.out.println("start...");
		threadQueue = new ArrayBlockingQueue<>(1);
		RejectedExecutionHandler rejectedExecutionHandler = new CaclCostPriceIgnorePolicy();

		calculateThreadPool = new ThreadPoolExecutor(1, 2, 2, TimeUnit.SECONDS, threadQueue,
				rejectedExecutionHandler);
		// 该增量true，则线程池数量最后销毁到0个(我觉得true)
		// 该增量false,销毁机制：超过核心线程数时，而且（超过一段时间或超时），就会销毁。
		calculateThreadPool.allowCoreThreadTimeOut(true);

	}

	public static class CaclCostPriceIgnorePolicy implements RejectedExecutionHandler {

		public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
			doLog(r, e);
		}

		private void doLog(Runnable r, ThreadPoolExecutor e) {
			// if (threadQueue.size() >= 1) { 如果流程中，没有这个判断，会被拒绝。。
			System.out.println(
					"rejected!!! " + r.toString() + " rejected,completedTaskCount:" + e.getCompletedTaskCount());
		}
	}

	public static void main(String[] args) {
		ClientThread3ChangeThreadSize clientThread = new ClientThread3ChangeThreadSize();
		clientThread.initCostInventoryThreadPoolService();
		for (int i = 1; i <= 5; i++) {
			clientThread.calculateThreadPool.setCorePoolSize(i);
			clientThread.calculateThreadPool.setMaximumPoolSize(i+1);
			clientThread.startclient();
		}

	}

	public void startclient() {
		
		Random random = new Random();
		

		int count = 1;
		while (count > 0) {
			
			String workerName = "_calculatePriceDaily_";
			for (int i = 1; i <= 5; i++) {
				System.out.println(String.format("getActiveCount:%s,threadQueue:%s,core:%s,max:%s",
						calculateThreadPool.getActiveCount(), threadQueue.size(),calculateThreadPool.getCorePoolSize(),calculateThreadPool.getMaximumPoolSize()));
				if (threadQueue.size() >= 1) {
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
					}
				}
				calculateThreadPool.execute(new working(workerName, new Long(i)));
			}
			count--;
		}

	}

	class working implements Runnable {
		private Long costList;
		private String workerName;

		public working(String workerName, Long costList) {
			this.workerName = workerName;
			this.costList = costList;
		}

		@Override
		public void run() {
			long start = System.currentTimeMillis();

			try {
				Thread.sleep(1000);
				System.out.println("working..." + costList);
			} catch (InterruptedException e) {
			}
			long end = System.currentTimeMillis();
			logger.info("calculatePriceDaily_working {} completed,total:{},timeConsuming:{}", workerName, end - start);

		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("working [costList=");
			builder.append(costList);
			builder.append(", workerName=");
			builder.append(workerName);
			builder.append("]");
			return builder.toString();
		}

	}
}
