package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * 并行流线程安全
 我看了下官方说明和一些源码，结论是使用了并行流的，如果使用了collect，是没有任何线程安全问题的。
这要从流是怎么设计的理解。
1、可以简单认为就是map-reduce, collect就是终端操作。之前的各种流操作，最终有一个结果supplier。
2、collect对所有supplier做了聚合。每个supplier对arraylist, hashmap单独有一份实例。如果是并行流，那么就有多种实例，这在最后合并的时候，不会出现原子性问题
3、至于为什么会说并行流不安全，是因为最后没有用到collect对supplier的处理，会导致非原子结果，如foreach就会有这样的问题 如本示例
4、再加一个源码图片，collect里面接收的supplier，每个流都实例化了一个arraylist
参考链接：Processing Data with Java SE 8 Streams, Part 1
https://www.oracle.com/technical-resources/articles/java/ma14-java-se-8-streams.html
 */
public class Java8toNewListTest {
	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
			list1.add(i);
		}
		
		//线程不安全
		list1.parallelStream().forEach(t -> {
			System.out.println(Thread.currentThread().getId());
			list3.add(t);
		});
//		System.out.println(list3.size());
		//线程安全
//		List<Integer> list4 = list1.parallelStream().map(t -> {
//			System.out.println(Thread.currentThread().getId());
//			return t;
//		}).collect(Collectors.toList());
//		System.out.println(list4.size());
	}
}