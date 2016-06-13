package com.paymoon.demo.threadpool.test;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * Java线程：线程池-固定线程数的线程池
 */
public class Test {
    public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        t1.setName("t111");
        Thread t2 = new MyThread();
        t2.setName("t2222");
        Thread t3 = new MyThread();
        t3.setName("t333");
        Thread t4 = new MyThread();
        t4.setName("t4444");
        Thread t5 = new MyThread();
        t5.setName("t555");
        Thread t6 = new MyThread();
        t6.setName("t666");
        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        // 关闭线程池
        pool.shutdown();
    }
}

