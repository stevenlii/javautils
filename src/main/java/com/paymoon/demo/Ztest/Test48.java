package com.paymoon.demo.Ztest;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test48 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Test48 test48 = new Test48();
		test48.test03();
	}

	public void test03() {
		LinkedBlockingQueue lbq = new LinkedBlockingQueue();// 可指定容量，也可不指定
		lbq.add("a");
		lbq.add("b");
		lbq.add("c");
		// API与ArrayBlockingQueue相同
		// 是否包含
		System.out.println(lbq.contains("a"));
		// 移除头部元素或者指定元素 remove("a")
		System.out.println(lbq.remove());
		// 转数组
		Object[] array = lbq.toArray();
		// element 取出头部元素，但不删除
		System.out.println(lbq.element());
		System.out.println(lbq.element());
		System.out.println(lbq.element());
	}
}
