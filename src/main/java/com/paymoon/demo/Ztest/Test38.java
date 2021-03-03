package com.paymoon.demo.Ztest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.java8.stream.Person;

public class Test38 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<Person> personList  = new ArrayList<>();
		Person p1 = new Person(1, "11lili", 11);
		Person p2 = new Person(2, "22rrrr", 22);
		Person p3 = new Person(3, "33sanan", 33);
		Person p4 = new Person(4, "44sisisi", 44);
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		System.out.println(personList);
//		for (int i = 0; i < personList.size(); i++) {
//			Person personItem = personList.get(i);
//			if (personItem.getId() == 2) {
//				personItem = new Person(5, "55wuwuwu", 55);
//				personList.set(i, personItem);
//			}
//			if (personItem.getId() == 4) {
//				personItem = new Person(6, "66liuliu", 66);
//				personList.set(i, personItem);
//			}
//		}
//		System.out.println(personList);
		for (Person personItem : personList) {
			if (personItem.getId() == 2) {
				personItem.setAge(66);
			}
			if (personItem.getId() == 4) {
				personItem.setMoney(new BigDecimal(5511));
			}
		}
		System.out.println(personList);
		
//		List<Person> personList2  = new ArrayList<>(personList.size());
//		for (int i = 0; i < personList.size(); i++) {
//		Person personItem = personList.get(i);
//		if (personItem.getId() == 2) {
//			personItem = new Person(5, "55wuwuwu", 55);
//			personList2.add(personItem);
//		}
//		if (personItem.getId() == 4) {
//			personItem = new Person(6, "66liuliu", 66);
//			personList2.add(personItem);
//		}
//	}
//		System.out.println(personList);
//		System.out.println(personList2);
		
	}
	
}
