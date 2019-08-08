package com.chen.demo;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
     public class CountDownLatchTest {
        private CountDownLatch countDownLatch = new CountDownLatch(1);
        public void method1(String name) {
            try {
                //countDownLatch.await();  //阻塞线程,到countDownLatch对象的count等于0时唤醒
                 countDownLatch.await(10L,TimeUnit.SECONDS); //阻塞线程,如果在10秒后还没有被唤醒,将自动唤醒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " - " + name + " 被唤醒");
        }
    
        public void method2(String name) {
            System.out.println(Thread.currentThread().getName() + "  " + name);
            try {
                TimeUnit.SECONDS.sleep(5);
                countDownLatch.countDown(); // 将count值减1
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        public static void main(String[] args) throws InterruptedException {
            CountDownLatchTest test = new CountDownLatchTest();
            new Thread(() -> {
                test.method1("method1");
            }).start();
            new Thread(() -> {
                test.method2("method2");
            }).start();
            new Thread(() -> {
                test.method1("method3");
            }).start();
        }
    
}