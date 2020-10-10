package com.paymoon.demo.java8.stream;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8toNewListTest {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");

		list1.parallelStream().filter(t -> t == "1").forEach(t -> System.out.println(t));
	}
}