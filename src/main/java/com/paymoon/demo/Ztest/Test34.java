package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test34 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		System.out.println((Integer.MAX_VALUE + 1));
		System.out.printf("%010x\n", (Integer.MAX_VALUE ));
	}
	
}
