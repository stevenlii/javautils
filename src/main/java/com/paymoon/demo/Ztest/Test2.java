package com.paymoon.demo.Ztest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test2 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		System.out.println(UUID.randomUUID().toString().length());
	}

	/**
	 * @author Administrator
	 * @deprecated we recommend the other method
	 *
	 */
	public static String getClazzName() {
		String clazzName3 = new Object() {
			public String getClassName() {
				String clazzName = this.getClass().getName();
				return clazzName.substring(0, clazzName.lastIndexOf('$'));
			}
		}.getClassName();
		return clazzName3;
	}
}
