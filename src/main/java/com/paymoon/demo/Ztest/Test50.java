package com.paymoon.demo.Ztest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.java8.stream.Person;

public class Test50 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<Person> persons = new ArrayList<>();
		Person person = new Person(1, "1");
		persons.add(person);
		person = new Person(1, "2");
		persons.add(person);
		person = new Person(3, "3");
		persons.add(person);
		person = new Person(4, "4");
		persons.add(person);
		System.out.println(persons.size());
		List<List<Person>> persons2 = new ArrayList<>();
		persons2.add(persons.subList(0, 4));
		System.out.println(persons2);
	}
}
