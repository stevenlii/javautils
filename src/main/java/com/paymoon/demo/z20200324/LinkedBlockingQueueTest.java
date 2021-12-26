package com.paymoon.demo.z20200324;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        final Queue<Integer> q1 = new LinkedBlockingQueue<Integer>();
        final Queue<Integer> q2 = new LinkedBlockingQueue<Integer>();
        final int n = 1000000;
        final int m = 100;

        for (int i = 0; i < n; i++) {
            q1.add(i);
        }

        List<Thread> ts = new ArrayList<Thread>();
        for (int i = 0; i < m; i++) {
            ts.add(new Thread(new Runnable() {
                public void run() {
                    int i = 0;
                    while (q2.size() < n && i++ < n / m) { // q2.size() 非线程安全，所以设置每个线程添加平均个数，防止poll出null报错
                        q2.add(q1.poll());
                    }
                }
            }));
        }

        for (Thread t : ts) {
            t.start();
        }

        System.out.println("启动了 " + m + " 个线程，每个线程处理 " + n / m + " 个操作");

        for (Thread t : ts) {
            while (t.isAlive()) {
                Thread.sleep(1);
            }
        }

        System.out.println("q1.size()：" + q1.size());
        System.out.println("q2.size()：" + q2.size());

        Set<Integer> set = new HashSet<Integer>();
        Integer i;
        while ((i = q2.poll()) != null) {
            set.add(i);
        }
        System.out.println("q2.size()：" + q2.size());
        System.out.println("set.size()：" + set.size());
    }
}
