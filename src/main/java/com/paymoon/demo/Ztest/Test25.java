package com.paymoon.demo.Ztest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test25 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		String resultStr = "{\r\n" + "  \"ret\": 1,\r\n" + "  \"data\": null\r\n" + "}";
		JSONObject jsonObject = JSON.parseObject(resultStr, JSONObject.class);
		if (jsonObject.containsKey("ret") && jsonObject.getInteger("ret") == 1) {
			JSONObject jsonObjectWithBomId = jsonObject.getJSONObject("data");
			if (jsonObjectWithBomId == null) {
				System.out.println("jsonObjectWithBomId :"+jsonObjectWithBomId);
			}
		}
	}
}
