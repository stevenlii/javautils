package com.paymoon.demo.z20200324;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest4 {
    private static ArrayBlockingQueue<String> q1 = new ArrayBlockingQueue<String>(100000);


	public static void main(String[] args) throws InterruptedException {

		final int m = 10000;

		List<Thread> ts = new ArrayList<Thread>();
		for (int i = 0; i < m; i++) {
			ts.add(new Thread(new Runnable() {
				public void run() {
					q1.offer("1");
				}
			}));
		}

		for (Thread t : ts) {
			t.start();
		}

		System.out.println("启动了 " + m + " 个线程");

		for (Thread t : ts) {
			while (t.isAlive()) {
				Thread.sleep(10);
			}
		}

		System.out.println("q1.size()：" + q1.size());

	}
}
