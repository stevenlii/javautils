package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Java8FlatMap2 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(new Integer(1), "haha",31));
		list.add(new Person(2, "rere",38));
		list.add(new Person(new Integer(1), "haha",31));
		List<Person> list2 = new ArrayList<>();
		list2.add(new Person(new Integer(1), "haha",31));
		list2.add(new Person(2, "rere",38));
		list2.add(new Person(new Integer(1), "haha",31));
		List<List<Person>> list3 = new ArrayList<List<Person>>();
		list3.add(list);
		list3.add(list2);
		System.out.println(list3);
		List<Person> list4 = list3.parallelStream().flatMap(t -> t.parallelStream()).collect(Collectors.toList());
		System.out.println(list4);
		
	}
	
}
