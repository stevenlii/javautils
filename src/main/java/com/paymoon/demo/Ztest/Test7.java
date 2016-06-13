package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test7 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		String escalationId="system";
		if (!escalationId.equals("") && !escalationId.equals("system")) {//不相等
			System.out.println("not");
		}else {//相等
			System.out.println("yes");
		}
	}
	/**
	 * @author Administrator
	 * @deprecated we recommend the other method
	 *
	 */
}
