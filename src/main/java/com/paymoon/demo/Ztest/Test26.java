package com.paymoon.demo.Ztest;

import java.util.HashSet;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.paymoon.demo.vo.Person;

public class Test26 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Person person = new Person();
		person.setId(new Long(100));
		Person person2 = new Person();
		person2.setId(100L);
		Set<Person> persons = new HashSet<Person>();
		persons.add(person);
		persons.add(person2);
		System.out.println(persons);
	}
}
