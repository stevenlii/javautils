package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.paymoon.demo.Util.MathDoubleUtil;

public class Test24 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.forEach(t -> System.out.println(t%2));
	}

}
