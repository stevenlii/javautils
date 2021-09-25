package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test47 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		new Test47().name();
	}
	public void name() {

		List<String> strings = new ArrayList<>();
		strings.add("1");
		strings.add("2");
		strings.add("3");
		strings.add("4");
		strings.add("5");
		
		System.out.println(strings);
		System.out.println("----------------------------");
		name2(strings);
		System.out.println(strings);
	}
	public int name2(List<String> strings) {
//		strings.remove(0);
		List<String> strings2 = new ArrayList<>();
		strings2.add("666");
		strings.clear();
		strings.addAll(strings2);
		
		return 0;
	}
}
