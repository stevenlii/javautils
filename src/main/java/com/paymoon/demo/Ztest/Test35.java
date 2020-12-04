package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.java8.stream.Person;

public class Test35 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		// 3 apple, 2 banana, others 1
		List<Person> list = new ArrayList<>();
		list.add(new Person(-1, "haha"));
		list.add(new Person(3, "haha"));
		list.add(new Person(8, "fefe",20));
		list.add(new Person(4, "fefe",20));
		
		
		list.sort(Comparator.comparing(Person::getId));
		System.out.println(list);
	}
	
}
