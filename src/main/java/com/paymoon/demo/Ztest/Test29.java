package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test29 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Test29 test25 = new Test29();
		Long mL = new Long(55);
		Integer Mi = new Integer(55);
		Map<Integer, Object> aaMap = new HashedMap();
		aaMap.put(Mi, test25);
//		if (aaMap.get(mL.intValue()) != null) {
//			System.out.println(true);
//		}else {
//			System.out.println(false);
//		}
		if (aaMap.containsKey(mL.intValue()) ) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	
}
