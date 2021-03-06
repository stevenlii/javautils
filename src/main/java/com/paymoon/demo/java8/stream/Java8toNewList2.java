package com.paymoon.demo.java8.stream;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8toNewList2 {
	public static void main(String[] args) {

// Create a list.
		final List<Person> customers = Arrays.asList(
				new Person(1, "haha",3),
				new Person(2, "rere",3),
				new Person(13, "fefe",4),
				new Person(1, "fefe",4)
		);

		// Turn into a list of Ids.
		final List<Person> ids = customers.stream().map(t -> {
			return  new Person(t.getId()+100, t.getName());
		}).collect(Collectors.toList());

		System.out.println("Ids = " + ids);

	}

}