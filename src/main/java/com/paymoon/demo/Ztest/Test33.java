package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test33 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		float a = 0.1f;
	float b = 1f;
	b += 0.1f;
	System.out.println("使用==判断是否相等:" + (a == b));// 超出精度范围
	}
	
}
