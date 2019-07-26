package com.paymoon.demo.Ztest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author stevenlii
 * @desc 处理java
 *       8中针对List集合，进行聚合的代码。针对对象集合，多条件进行聚合，结合apache.commons的Pair对象，和Lambda表达式，可以达到多条件聚合
 */
public class Java8groupingBy2 {
	public static void main(String[] args) {
		// 3 apple, 2 banana, others 1
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "haha"));
		list.add(new Person(2, "rere"));
		list.add(new Person(1, "fefe"));
		System.out.println(list);
		Map<Integer, List<Person>> result2 = list.parallelStream().collect(Collectors.groupingBy(t -> t.getId()));
		System.out.println(result2);
	}
}