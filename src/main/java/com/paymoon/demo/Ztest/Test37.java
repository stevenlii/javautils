package com.paymoon.demo.Ztest;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test37 {
	public static void main(String[] args) 
    {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
         
        for (int i = 1; i <= 5; i++) 
        {
            Task task = new Task("Task" + i);
            executor.execute(task);
        }
        executor.shutdown();
    }
	

}
