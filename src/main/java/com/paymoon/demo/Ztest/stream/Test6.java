package com.paymoon.demo.Ztest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
	public static void main(String[] args) {
 
		List<Person> list = new ArrayList();
		list.add(new Person(1, "haha",3));
		list.add(new Person(2, "rere",3));
		list.add(new Person(13, "fefe",4));



        double total = list.stream().collect(Collectors.summingDouble(Person::getId));

		System.out.println(total);
	}

}