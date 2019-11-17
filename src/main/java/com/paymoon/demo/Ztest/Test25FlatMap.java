package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test25FlatMap {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
//		List<Integer> list = Arrays.asList(1,2,3,4,5);
//		System.out.println(list);
//		List<Integer> list2 = list.parallelStream().map(t -> t*t).collect(Collectors.toList());
//		System.out.println(list2);
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(3,4);
		List<int[]> pairs =
				numbers1.stream()
				.flatMap(i -> numbers2.stream()
				.map(j -> new int[]{i, j})
				)
				.collect(Collectors.toList());
		pairs.forEach(t -> Arrays.stream(t).forEach(i -> System.out.println(i)));
		System.out.println();
		
		boolean isnull =
				numbers1.stream()
				.flatMap(i -> numbers2.stream()
				.map(j -> new int[]{i, j})
				).findAny().isPresent();
	}

}
