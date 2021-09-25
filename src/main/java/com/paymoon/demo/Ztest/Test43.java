package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.paymoon.demo.java8.stream.Person;

public class Test43 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		// 3 apple, 2 banana, others 1
		List<Person> tagsInfos = null;
//		if (CollectionUtils.isEmpty(tagsInfos)) {
//			tagsInfos = new ArrayList<>();
//		}
		Map<Integer, List<Person>> tagsInfoMap = tagsInfos.parallelStream().filter(t -> t.getId() != null)
				.collect(Collectors.groupingBy(Person::getId));
		
		System.out.println(1111);
	}
	
}
