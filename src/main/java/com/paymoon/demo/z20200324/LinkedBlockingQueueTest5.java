package com.paymoon.demo.z20200324;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class LinkedBlockingQueueTest5 {

	public static final Map<String, LinkedBlockingQueue<String>> segmentMap = new ConcurrentHashMap<>();

	public static void main(String[] args) throws InterruptedException {
		final int m = 10000;
		CountDownLatch countDownLatch = new CountDownLatch(m);
		List<WorkThread> ts = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			ts.add(new WorkThread(countDownLatch));
		}

		for (Thread t : ts) {
			t.start();
		}

		System.out.println("启动了 " + m + " 个线程");
		try {
            countDownLatch.await();
        } catch (InterruptedException e) {
        }

		List<String> keys = new ArrayList<>(segmentMap.keySet());
		System.out.println("共分了多少桶：" + keys.size());
		List<LinkedBlockingQueue<String>> queueList = new ArrayList<>(segmentMap.values());
		int queueContent = queueList.stream().collect(Collectors.summingInt(LinkedBlockingQueue::size));
		System.out.println("共有多少消息：" + queueContent);
	}

	static class WorkThread extends Thread {
		private CountDownLatch countDownLatch;

		public WorkThread(CountDownLatch countDownLatch) {
			this.countDownLatch = countDownLatch;
		}

		@Override
		public  void run() {
			try {
				Random random = new Random();
				int randomNum = random.nextInt(10);
				if (segmentMap.containsKey(String.valueOf(randomNum))
						&& segmentMap.get(String.valueOf(randomNum)) != null) {
					segmentMap.get(String.valueOf(randomNum)).offer(String.valueOf(randomNum));
				} else {
					LinkedBlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
					messageQueue.offer(String.valueOf(randomNum));
					segmentMap.put(String.valueOf(randomNum), messageQueue);
					
				}
				countDownLatch.countDown();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
