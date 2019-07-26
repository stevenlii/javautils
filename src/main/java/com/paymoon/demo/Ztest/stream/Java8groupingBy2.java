package com.paymoon.demo.Ztest.stream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Java8groupingBy2 {
    public static void main(String[] args) {
        //3 apple, 2 banana, others 1
    	List<Person> list = new ArrayList();
		list.add(new Person(1, "haha"));
		list.add(new Person(2, "rere"));
		list.add(new Person(1, "fefe"));
        System.out.println(list);
        int i = 13;
        Map<Integer, List<Person>> result2 =
        		list.parallelStream().collect(
                        Collectors.groupingBy(
                                t -> t.getId()
                        )
                );
        System.out.println(result2);
    }
}