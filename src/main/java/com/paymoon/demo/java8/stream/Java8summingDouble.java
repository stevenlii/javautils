package com.paymoon.demo.java8.stream;
 
import java.util.*;
import java.util.stream.Collectors;

public class Java8summingDouble {
	public static void main(String[] args) {
 
		List<Person> list = new ArrayList();
		list.add(new Person(1, "haha"));
		list.add(new Person(2, "rere"));
		list.add(new Person(13, "fefe"));
 
 
		
		 double total = list.stream().collect(Collectors.summingDouble(Person::getId));
 
		System.out.println(total);
	}

}