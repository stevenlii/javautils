package com.paymoon.demo.java8.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8MaptoList {
	public static void main(String[] args) {

		List<Person> list = new ArrayList();
		list.add(new Person(1, "1A1A"));
		list.add(new Person(2, "2B2B"));
		list.add(new Person(3, "3C3C"));

//		Map<Integer, Person> mapp = list.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
//
//		System.out.println("mapp = " + mapp);
//
//		System.out.println(mapp.get(1).getName());
		// 这个方法有问题，详情请见：
		// Java8 Collectors.toMap的坑 - 八行书 - CSDN博客
		// https://blog.csdn.net/u013805360/article/details/82686009
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName, (a, b) -> b));

		System.out.println(map);
		List<Integer> personIdlist = map.keySet().parallelStream().collect(Collectors.toList());
		System.out.println(personIdlist);
	}


}