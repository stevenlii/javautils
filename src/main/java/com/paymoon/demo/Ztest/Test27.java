package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test27 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		System.out.println(list);
//		List<Integer> list2 = list.parallelStream().map(t -> t*t).collect(Collectors.toList());
//		System.out.println(list2);
		String area_scope = list.parallelStream().map(t -> String.valueOf(t))
				.collect(Collectors.joining(":2;"));
		System.out.println(area_scope+":2;");
	}

}
