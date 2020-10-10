package com.paymoon.demo.java8.stream;

import java.awt.print.Paper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8toNewList {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("2");
		list1.add("3");

		List<String> list2 = list1.stream().map(string -> {
			return "stream().map()处理之后：" + string;
		}).collect(Collectors.toList());

		list2.stream().forEach(string -> {
			System.out.println(string);
		});
//运行结果：
//stream().map()处理之后：1 
//stream().map()处理之后：2
//stream().map()处理之后：3}

	}
}