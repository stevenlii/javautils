package com.paymoon.demo.Ztest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class AvertEB001 {
	public static void main(String[] args) {
		String sourceNumber = "0.1 MB";
		String targetNumber = avertUnit(sourceNumber);
		System.out.println(String.format("sourceNumber:%s, targetNumber:%s", sourceNumber, targetNumber));
	}

	private static String avertUnit(String number) {
		// 1. 验证参数
		if (StringUtils.isEmpty(number) || number.split(" ").length != 2) {
			return "number is wrong";
		}
		// init byteMap
		Map<String, Double> byteMap = new HashMap();
		byteMap.put("B", 1d);
		byteMap.put("KB", 1024d);
		byteMap.put("MB", 1024 * 1024d);
		byteMap.put("GB", 1024 * 1024 * 1024d);
		byteMap.put("TB", 1024 * 1024 * 1024 * 1024d);
		byteMap.put("PB", 1024 * 1024 * 1024 * 1024 * 1024d);
		byteMap.put("EB", 1024 * 1024 * 1024 * 1024 * 1024 * 1024d);
		
		// 3.
		String unit = "";
		double result = 0;
		String[] numberArr = number.split(" ");
		if (byteMap.containsKey(numberArr[1])) {
			double numberl = Double.parseDouble(numberArr[0]);
			double bnumber = byteMap.get(numberArr[1]) * numberl;

			if ((bnumber / byteMap.get("EB")) > 1) {
				result = bnumber / byteMap.get("EB");
				unit = "EB";
			}
			else if (bnumber / byteMap.get("PB") > 1) {
				result = bnumber / byteMap.get("PB");
				unit = "PB";
			}
			else if (bnumber / byteMap.get("TB") > 1) {
				result = bnumber / byteMap.get("TB");
				unit = "TB";
			}
			else if (bnumber / byteMap.get("GB") > 1) {
				result = bnumber / byteMap.get("GB");
				unit = "GB";
			}
			else if (bnumber / byteMap.get("MB") > 1) {
				result = bnumber / byteMap.get("MB");
				unit = "MB";
			}
			else if (bnumber / byteMap.get("KB") > 1) {
				result = bnumber / byteMap.get("KB");
				unit = "KB";
			}
			else if (bnumber / byteMap.get("B") > 1) {
				result = bnumber / byteMap.get("B");
				unit = "B";
			}
		}
		return result + " " + unit;
	}
}
