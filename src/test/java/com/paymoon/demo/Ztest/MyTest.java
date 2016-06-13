package com.paymoon.demo.Ztest;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

public class MyTest extends TestCase {
	public static void test2() {}
	public static void main(String[] args) {
		String endpoint = "http://1412580518114250.mns.cn-beijing.aliyuncs.com/queues/myfirstqueue";
		String[] endpointArr = endpoint.split("/");
		System.out.println(endpointArr[0]+"//"+endpointArr[2]);
			System.out.println(endpointArr[endpointArr.length - 1]);
	}
}
