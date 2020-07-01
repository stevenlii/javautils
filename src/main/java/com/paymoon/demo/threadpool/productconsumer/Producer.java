package com.paymoon.demo.threadpool.productconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

class Producer implements Runnable {
    // 库存队列
    private BlockingQueue<String> stock;
    // 生产/消费延迟
    private int timeOut;
    private String name;

    public Producer(BlockingQueue<String> stock, int timeout, String name) {
        this.stock = stock;
        this.timeOut = timeout;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                stock.put(name);
                System.out.println(name + " 正在生产数据" + " -- 库存剩余：" + stock.size());
                TimeUnit.MILLISECONDS.sleep(timeOut);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}