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
public class Java8ListComparing {
    public static void main(String[] args) {
    	List<Person> persons = new ArrayList<>();
		persons.add(new Person(new Integer(1), "haha",31));
		persons.add(new Person(new Integer(1), "haha",31));
		persons.add(new Person(3, "haha",40));
		persons.add(new Person(2, "rere",38));
		persons.add(new Person(2, "rere",38));
		persons.add(new Person(3, "cccc",40));
		
		
		/**
		 * 根据name去重
		 * 如果多则取第一个
		 */
		List<Person> uniqueName = persons.stream().collect(
		            Collectors.collectingAndThen(
		                    Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))), ArrayList::new)
		);
		System.out.println(uniqueName);
		/**
		 * 根据name,age两个属性去重
		 * 如果多则取第一个
		 */
		List<Person> uniqueNameAge = persons.stream().collect(
				Collectors.collectingAndThen(
						Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(person -> person.getName()+"_"+person.getAge()))), ArrayList::new)
				);
		System.out.println("uniqueNameAge >> "+uniqueNameAge);
    }
    
}