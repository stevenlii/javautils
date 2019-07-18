package com.paymoon.demo.Ztest.stream;
 
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
public class Java8toMap {
	public static void main(String[] args) {
 
		List<Person> list = new ArrayList();
		list.add(new Person(1, "haha"));
		list.add(new Person(2, "rere"));
		list.add(new Person(1, "fefe"));
 
 
		
//		Map<Integer, Person> mapp = list.stream().collect(Collectors.toMap(Person::getId, Function.identity()));
//
//		System.out.println("mapp = " + mapp);
//
//		System.out.println(mapp.get(1).getName());
		//这个方法有问题，详情请见：
		//Java8 Collectors.toMap的坑 - 八行书 - CSDN博客
		//https://blog.csdn.net/u013805360/article/details/82686009
		Map<Integer, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName,(a,b) -> b));
 
		System.out.println(map);
		System.out.println(getTimesmorning(new Date()));
	}
	public static int getTimesmorning(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(11, 0);
		cal.set(13, 0);
		cal.set(12, 0);
		cal.set(14, 0);
		return (int)(cal.getTimeInMillis() / 1000L);
	}
 
}