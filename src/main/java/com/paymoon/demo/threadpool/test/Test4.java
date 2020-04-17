package com.paymoon.demo.threadpool.test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java线程：线程池-固定线程数的线程池
 * https://www.ibm.com/developerworks/cn/java/j-lo-taskschedule/
 */
public class Test4 {
    public static void main(String[] args) {
    	List<String> skuIds = new ArrayList<String>();
    	skuIds.add("1,A");
    	skuIds.add("2,B");
    	skuIds.add("3,C");
    	System.out.println(skuIds.parallelStream().map(t -> {
    		return t.split(",")[0];
    	}).collect(Collectors.toList()));
    }
}

