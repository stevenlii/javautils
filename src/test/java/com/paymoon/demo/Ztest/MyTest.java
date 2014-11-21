package com.paymoon.demo.Ztest;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class MyTest extends TestCase {
	@org.junit.Test	
	public void test2() {
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(map.get("1"));
		System.out.println(map.get("2"));
	}
}
