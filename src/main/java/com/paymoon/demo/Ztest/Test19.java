package com.paymoon.demo.Ztest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test19 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		String fackKey = map.get("fackKey");
		if (StringUtils.isNotBlank(fackKey)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}

}
