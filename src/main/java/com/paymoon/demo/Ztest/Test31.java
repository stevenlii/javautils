package com.paymoon.demo.Ztest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test31 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Test31 test31  = new Test31();
		synchronized (test31) {
			synchronized (test31) {
				
				System.out.print("true异常, false 是正常:");
			}
			System.out.print("true异常, false 是正常:");
		}
		
	}

}
