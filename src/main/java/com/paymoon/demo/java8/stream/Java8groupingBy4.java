package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.axis.utils.tcpmon;

/**
 * @author stevenlii
 * @desc 处理java
 *       8中针对List集合，进行聚合的代码。针对对象集合，多条件进行聚合，结合apache.commons的Pair对象，和Lambda表达式(personGroupFunction)，可以达到多条件聚合
 */
public class Java8groupingBy4 {
	public static void main(String[] args) {
		// 3 apple, 2 banana, others 1
		List<Person> list = new ArrayList<>();
//		list.add(new Person(-1, "haha"));
//		list.add(new Person(3, "haha"));
		list.add(new Person(-1, "fefe",20));
		list.add(new Person(3, "fefe",20));
//		System.out.println(list);
		
//		List<Person> listResult = getCustomPerson(3,list);
		List<Person> listResult = getCustomPerson(4,list);
		
		System.out.println(listResult);
	}

	private static List<Person> getCustomPerson(Integer id,List<Person> list) {
		List<Person> listResult = new ArrayList<>();
		Function<Person,Person> personGroupFunction = new PersonGroupFunction();
		Map<Person, Set<Person>> result2 = list.parallelStream().collect(Collectors.groupingBy(personGroupFunction,Collectors.toSet()));
		result2.forEach((k,v) -> {
			Optional<Person> personOptional = v.parallelStream().filter(t -> t.getId().intValue() == id).findAny();
			if (personOptional.isPresent()) {
				listResult.add(personOptional.get());
			}else {
				personOptional = v.parallelStream().filter(t -> t.getId() == -1).findAny();
				if (personOptional.isPresent()) {
					Person personWithOutId = personOptional.get();
					personWithOutId.setId(id);
					listResult.add(personWithOutId);
				}
			}
		});
		return listResult;
	}
	private static List<Person> getCustomPerson(List<Person> list) {
		List<Person> listResult = new ArrayList<>();
		Function<Person,Person> personGroupFunction = new PersonGroupFunction();
		Map<Person, Set<Person>> result2 = list.parallelStream().collect(Collectors.groupingBy(personGroupFunction,Collectors.toSet()));
		result2.forEach((k,v) -> {
			Optional<Person> personOptional = v.parallelStream().filter(t -> t.getId() == 3).findAny();
			if (personOptional.isPresent()) {
				listResult.add(personOptional.get());
			}else {
				personOptional = v.parallelStream().filter(t -> t.getId() == -1).findAny();
				if (personOptional.isPresent()) {
					listResult.add(personOptional.get());
				}
			}
		});
		return listResult;
	}
}