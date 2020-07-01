package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java 8 | Consumer Interface in Java with Examples - GeeksforGeeks
 * https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
 * 
 * @author MC
 *
 */
public class Java8Peek {
	public static void main(String args[]) {
		List<Integer> list = new ArrayList<>();
//		    List<Integer> result = Stream.of(1, 2, 3, 4)
//		            .peek(x -> list.add(x))
//		            .map(x -> x * 2)
//		            .filter(x -> x > 8)
//		            .collect(Collectors.toList());
//
//		    System.out.println(list);
//		    System.out.println(result);

		/**
		 * 在java-8中，该列表已填充，但在jdk-9中，根本未调用peek。
		 * 由于您未使用过滤器或平面图，因此您无需修改Stream的大小，并且count只需要它的大小即可； 因此，根本不要求偷看。
		 * 因此，依靠偷看是一个非常糟糕的策略。
		 */
		long howMany = Stream.of(1, 2, 3, 4).peek(x -> list.add(x)).count();

		System.out.println(list);
		System.out.println(howMany);
	}
}
