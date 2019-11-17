package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Java8FlatMap {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<String> words = Arrays.asList("Hello","world");
		String[] stringsArr = new String[]{"Hello","World"};
		logger.info("strings:{},stringsArr:{}",words,stringsArr);
		List<String[]> words2 = words.stream()
		.map(word -> word.split(""))
		.distinct()
		.collect(Collectors.toList());
		words2.forEach(t -> System.out.println(Arrays.asList(t)));
		
		Stream<String> streamOfwords = Arrays.stream(stringsArr);
		
		List<String[]> words3 = streamOfwords.map(word -> word.split(""))
		.distinct()
		.collect(Collectors.toList());
		words3.forEach(t -> System.out.println(Arrays.asList(t)));
		List<String> words4 = Arrays.stream(stringsArr).map(word -> word.split("")).flatMap(Arrays::stream)
				.collect(Collectors.toList());
		words4.forEach(t -> System.out.println(Arrays.asList(t)));
	}
	
}
