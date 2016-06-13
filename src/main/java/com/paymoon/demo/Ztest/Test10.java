package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test10 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		System.out.println(1);
		List<List<Boolean>> booleansall = new ArrayList<>();
		List<Boolean> booleans = new ArrayList<>();
		List<Boolean> booleans2 = new ArrayList<>();
		booleans2 = null;
		for (Boolean boolean1 : booleans2) {
			System.out.println(boolean1);
		}
	}
	
}
