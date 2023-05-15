package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test12Swap {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<Integer> aa = new ArrayList<>(5);
		aa.add(1);
		aa.add(2);
		aa.add(3);
		aa.add(4);
		aa.add(5);
		System.out.println(aa);
		int n1 = aa.get(0);
		int n2 = aa.get(4);
		n1 = n1 ^ n2;
		n2 = n1 ^ n2;
		n1 = n1 ^ n2;
		aa.set(0, n1);
		aa.set(4, n2);
		n1 = aa.get(1);
		n2 = aa.get(3);
		n1 = n1 ^ n2;
		n2 = n1 ^ n2;
		n1 = n1 ^ n2;
		aa.set(1, n1);
		aa.set(3, n2);
		System.out.println(aa);
	}

}
