package com.paymoon.demo.java8.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

public class Java8MapContainsKey {
	public static void main(String[] args) {

		Map<String, String> fields = new HashMap<>();
		fields.put("a", "value a");
		fields.put("z", "value z");
//		String[] candidates = "d|b|c|d".split("|");
		String[] candidates = "".split("|");
		boolean exists = false;
		if(ArrayUtils.isEmpty(candidates) || StringUtils.isEmpty(candidates[0])) {
			exists = true;
		}else {
			exists = Arrays.stream(candidates).anyMatch(fields::containsKey);
		}

		System.out.println(exists);
		System.out.println(candidates.length);
		System.out.println(candidates[0]);
	}

}