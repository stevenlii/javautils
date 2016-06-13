package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test12 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Long l1 = 1111L;
		Long l2 = 1111L;
		
		if (l1.longValue() == l2) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	
}
