package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;

public class Java8toNewList3 {
	public static void main(String[] args) {

// Create a list.
		final List<Person> customers = Arrays.asList(
				new Person(1, "haha",3),
				new Person(2, "rere",3),
				new Person(13, "fefe",4),
				new Person(1, "fefe", 4)
				);

		// Turn into a list of Ids.
		List<Person> ids = customers.stream().map(t -> {
			Person p2 = new Person();
			BeanUtils.copyProperties(customers.get(0), p2);
			p2.setId(t.getId() + 100);
			return p2;
		}).collect(Collectors.toList());

		System.out.println("Ids = " + ids);

	}

}