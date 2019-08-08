package com.paymoon.demo.cache.countdownlatch2;

import java.util.concurrent.CountDownLatch;

public class MainInstance {
    public static void main(String[] args) {
    	CountDownLatch controller = new CountDownLatch(10);

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Participant("P-" + i, controller));
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        try {
			controller.await();
			System.out.println("done...");
		} catch (InterruptedException e) {
		}
    }
}