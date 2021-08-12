package com.paymoon.demo.Ztest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.vo.Person2;


public class Test38 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<Person2> personList  = new ArrayList<>();
		Person2 p1 = new Person2(10,"aaa");
		Person2 p2 = new Person2(12,"bbb");
		Person2 p3 = new Person2(11,"ccc");
		Person2 p4 = new Person2(13,"ddd");
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		System.out.println(personList);
		System.out.println("______________________________________");
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
		for (Person2 personItem : personList) {
			if (personItem.getId() % 2 == 0) {
			personItem.getP2().setFirstname("newp2"+personItem.getId());
//				personItem.setP2(personItem.getP2());
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"\"}\n");
		return builder.toString();
	}
	
}
