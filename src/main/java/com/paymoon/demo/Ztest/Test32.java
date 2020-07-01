package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test32 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		float a = 20.222222225f;
	float b = 10.222222229f;
	System.out.println("使用==判断是否相等:" + (a == b));// 超出精度范围
	System.out.println("使用Math.abs()判断是否相等:" + (Math.abs(a - b) >= 0));
	System.out.println("比较a是否大于b:" + (a > b));
	System.out.println("比较b是否大于a:" + (a < b));
	}
	
}
