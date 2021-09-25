package com.paymoon.demo.Ztest;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class Test42 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		
	}

	public static HashMap<String, Object> detailInfo2Map(Object detailInfo) {
		HashMap<String, Object> detailMap = new HashMap<>();
		if (detailInfo == null) {
			return detailMap;
		}
		detailMap = JSON.parseObject(JSON.toJSONString(detailInfo), new TypeReference<HashMap<String, Object>>() {
		});
		return detailMap;
	}
}
