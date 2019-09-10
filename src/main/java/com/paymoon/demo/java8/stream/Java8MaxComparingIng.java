package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8MaxComparingIng {
	public static void main(String[] args) {
 
		List<Person> list = new ArrayList();
		list.add(new Person(1, "haha",8));
		list.add(new Person(10, "rere",16));
		list.add(new Person(13, "fefe",4));



		Person p = list.parallelStream().max(Comparator.comparingInt(t->(t.getAge()-t.getId()))).get();
		Person p2 = list.parallelStream().min(Comparator.comparingInt(t->(t.getAge()-t.getId()))).get();

		System.out.println(p);
		System.out.println(p2);
	}

}