package com.paymoon.demo.java8.stream;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8MaxComparingBigDecimal {
	public static void main(String[] args) {
 
		List<Person> list = new ArrayList();
		list.add(new Person(1, "haha",8,new BigDecimal(10)));
		list.add(new Person(10, "rere",16,new BigDecimal(10.1)));
		list.add(new Person(13, "fefe",4,new BigDecimal(10.2111)));



		Person p = list.parallelStream().max(Comparator.comparing(t-> t.getMoney())).get();
		Person p2 = list.parallelStream().min(Comparator.comparing(t->t.getMoney())).get();
		BigDecimal pMin = list.parallelStream().map(t -> t.getMoney()).min(Comparator.comparing(t->t)).get();
		BigDecimal pMax = list.parallelStream().map(t -> t.getMoney()).max(Comparator.comparing(t->t)).get();


		
		System.out.println(p);
		System.out.println(p2);
		System.out.println(pMin);
		System.out.println(pMax);
	}

}