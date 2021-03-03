package com.paymoon.demo.java8.stream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
/**
 * 
 * @author stevenlii
 *@desc 使用 Java8的 stream对list数据去重，使用filter()过滤列表
https://blog.csdn.net/ianly123/article/details/82658622
 */
public class Java8ListComparingSort {
    public static void main(String[] args) {
    	List<Person> persons = new ArrayList<>();
		persons.add(new Person(new Integer(1), "haha",31));
		persons.add(new Person(new Integer(1), "haha",31));
		persons.add(new Person(3, "haha",40));
		persons.add(new Person(2, "rere",38));
		persons.add(new Person(2, "rere",38));
		persons.add(new Person(3, "cccc",40));
		
		System.out.println(persons);
		/**
		 * 根据age 正向排序 ascend
		 */
		persons = persons.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
		System.out.println(persons);
		
		/**
		 * descend 序
		 */
		persons = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
		System.out.println(persons);
    }
    
}