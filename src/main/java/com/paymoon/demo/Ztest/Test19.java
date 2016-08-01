package com.paymoon.demo.Ztest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test19 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		//结果true才会进入异常, false 是正常
		//单个为true为正常，false为异常
		System.out.print("true异常, false 是正常:");
System.out.println( !(false&&true&&true  ) && true );
System.out.println(true&&false);
		
	}

}
