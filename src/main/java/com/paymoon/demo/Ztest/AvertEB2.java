package com.paymoon.demo.Ztest;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 *
 */
public class AvertEB2 {
	public static void main(String[] args) {
		String sourceNumber = "78946 MB";
		String[] unitArr = new String[] { "B", "KB", "MB", "GB", "TB", "PB", "EB" };
		// 1. 验证参数
		if (StringUtils.isEmpty(sourceNumber) || sourceNumber.split(" ").length != 2) {
			System.out.println("sourceNumber is invalid!");
			return;
		}
		String[] arr = sourceNumber.split(" ");
		int i = -1;
		for (int j = 0; j < unitArr.length; j++) {
			if (unitArr[j].equals(arr[1])) {
				i = j;
				break;
			}

		}
		if (i == -1) {
			System.out.println("sourceNumber is invalid!");
			return;
		}
		String targetNumber = avertUnit(arr[0] + " " + i);
		String[] arr2 = targetNumber.split(" ");
		targetNumber = arr2[0] + " " + unitArr[Integer.parseInt(arr2[1])];
		System.out.println(String.format("sourceNumber:%s, targetNumber:%s", sourceNumber, targetNumber));
	}

	private static String avertUnit(String number) {
		String[] arr = number.split(" ");
		double res = Double.parseDouble(arr[0]);
		int i = Integer.parseInt(arr[1]);
		if (res > 1024) {
			while (res > 1024) {
				res = res / 1024;
				i++;
			}

		} else if (res < 1) {
			while (res < 1) {
				res = res * 1024;
				i--;
			}
		}

		return res + " " + i;
	}

}
