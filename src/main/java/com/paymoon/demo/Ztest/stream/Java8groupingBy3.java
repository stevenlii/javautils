package com.paymoon.demo.Ztest.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
public class Java8groupingBy3 {
    public static void main(String[] args) {
        //3 apple, 2 banana, others 1
    	List<Person> list = new ArrayList();
		list.add(new Person(1, "haha",31));
		list.add(new Person(2, "rere",38));
		list.add(new Person(3, "haha",31));
        System.out.println(list);
        int i = 13;
        Map<Pair<String, Integer>, List<Person>> result2 =
        		list.parallelStream().collect(Collectors.groupingBy(p -> Pair.of(p.getName(), p.getAge())));
        for (Entry<Pair<String, Integer>, List<Person>> entry : result2.entrySet()) {
        	   System.out.print("key= " + entry.getKey().getKey() );
        	   System.out.print(" key= " + entry.getKey().getValue() );
        	   System.out.print(" and value= " + entry.getValue());
        	   System.out.println();
        }
        System.out.println(result2);
    }
}