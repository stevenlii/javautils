package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test13 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		int sugar = -20;
		map.put("level", String.valueOf(sugar));
		String level = map.get("level1");
		int aa = 100;
		aa = aa+Integer.valueOf(level);
		System.out.println(aa);
	}
	
}
