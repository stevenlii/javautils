package com.paymoon.demo.Ztest;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

public class Task implements Runnable {
    private String name;
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public Task(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void run() {
    	System.out.println(threadLocal.get());
    	System.out.println(threadLocal.toString());
        try {
            Long duration = (long) (Math.random() * 10);
            System.out.println("Executing : " + name);
            if (StringUtils.equals(name, "Task1")) {
            	threadLocal.set(name);
			}
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}