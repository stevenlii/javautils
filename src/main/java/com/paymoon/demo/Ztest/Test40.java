package com.paymoon.demo.Ztest;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.paymoon.demo.vo.Person2;

public class Test40 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		new Test40().testMap();
	}
	public void testMap () {
		Person2 p2 = new Person2();
		HashMap<String, Object> detailMap = p2.detailInfo2Map(p2.getDetail());
		System.out.println(detailMap.get("cc"));
		detailMap.put("ee", new Person2());
		p2.setDetail(detailMap);
		System.out.println(JSON.toJSONString(p2.getDetail()));
		
	}
}
