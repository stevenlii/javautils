package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test15 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		String noName = "one@aaa.com";
		System.out.println(noName.substring(0, noName.indexOf("@")));;
		
	}
	
}
