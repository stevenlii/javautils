package com.paymoon.demo.Ztest.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8toList {
	public static void main(String[] args) {

// Create a list.
		final List<Person> customers = Arrays.asList(
				new Person(1, "haha",3),
				new Person(2, "rere",3),
				new Person(13, "fefe",4),
				new Person(1, "fefe",4)
		);

		// Turn into a list of Ids.
		final List<Integer> ids = customers.stream()
				.map(Person::getId)
				.collect(Collectors.toList());

		System.out.println("Ids = " + ids);

	}

}