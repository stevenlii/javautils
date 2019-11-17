package com.paymoon.demo.java8.stream;

import java.util.Optional;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Java8Reduce {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		Optional accResult = Stream.of(8, 3, 9, 1)
		        .reduce((acc, item) -> {
		            System.out.println("acc : "  + acc +", item:"+item);
//		            acc += item;
//		            System.out.println("item: " + item);
//		            System.out.println("acc+ : "  + acc);
		            System.out.println("--------");
		            return acc;
		        });
		System.out.println("accResult: " + accResult.get());
		System.out.println("--------");
	}

}
