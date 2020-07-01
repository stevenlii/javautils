package com.paymoon.demo.threadpool.productconsumer.semaphore;

public class SemaphoreTest {
    public static void main(String[] args) {
        // 用于多线程操作的库存变量
        final Stock stock = new Stock();
        // 定义两个生产者和两个消费者
        Thread dellProducer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    stock.put("Del");
                }
            }
        });
        Thread macProducer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    stock.put("Mac");
                }
            }
        });
        Thread consumer1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    stock.get("zhangsan");
                }
            }
        });
        Thread consumer2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    stock.get("李四");
                }
            }
        });
        dellProducer.start();
        macProducer.start();
        consumer1.start();
        consumer2.start();
    }
}