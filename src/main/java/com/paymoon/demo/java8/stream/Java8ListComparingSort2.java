package com.paymoon.demo.java8.stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
/**
 * 
 * @author stevenlii
 * Java8 使用 stream().sorted()对List集合进行排序 - 代码猫 - 博客园
https://www.cnblogs.com/codecat/p/10873757.html
 */
public class Java8ListComparingSort2 {
    public static void main(String[] args) {
    	List<Person> persons = new ArrayList<>();
		persons.add(new Person(new Integer(1), "11111",31));
		persons.add(new Person(new Integer(1), "22222",31));
		persons.add(new Person(3, "33333",40));
		persons.add(new Person(2, "44444",38));
		persons.add(new Person(2, "33333",38));
		persons.add(new Person(3, "66666",40));
		/**
		 * comparing (非数字类型，实际里面是数字类型的，也可排序）
		 */
		persons = persons.stream().sorted(Comparator.comparing(Person::getName).reversed()).collect(Collectors.toList());
		System.out.println(persons);
		/**
		 * 想使用person -> person.getName()这种表达式的，就不能.reversed(),需要使用：, Collections.reverseOrder()
		 */
		persons = persons.stream().sorted(Comparator.comparing(person -> person.getName())).collect(Collectors.toList());
		System.out.println(persons);
		persons = persons.stream().sorted(Comparator.comparing(person -> person.getName(), Collections.reverseOrder())).collect(Collectors.toList());
		System.out.println(persons);
    }
    
}