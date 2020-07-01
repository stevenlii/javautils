package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test25 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Test25 test25 = new Test25();
		Long mL = new Long(55);
		Integer Mi = new Integer(55);
		Map<Integer, Object> aaMap = new HashedMap();
		aaMap.put(Mi, test25);
		if (aaMap.get(mL.longValue()) != null) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	
}
