package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Java 8 | Consumer Interface in Java with Examples - GeeksforGeeks
 * https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/
 * 
 * @author MC
 *
 */
public class Java8ConsumerAndThen3 {
	public static void main(String args[]) {

		// Consumer to multiply 2 to every integer of a list
		Consumer<List<Integer>> modify = list -> {
			for (int i = 0; i <= list.size(); i++)
				list.set(i, 2 * list.get(i));
		};

		// Consumer to display a list of integers
		Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
		System.out.println();

		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(1);
		list.add(3);

		// using addThen()
		try {
			dispList.andThen(modify).accept(list);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
