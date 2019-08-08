package com.paymoon.demo.java8.stream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * 
 * @author stevenlii
 *@desc 处理java 8中针对List集合差集
 */
public class Java8ListReduce {
    public static void main(String[] args) {
//    	 List<String> list1 = new ArrayList();
//         list1.add("1111");
//         list1.add("2222");
//         list1.add("3333");
//
//         List<String> list2 = new ArrayList();
//         list2.add("3333");
//         list2.add("4444");
//         list2.add("5555");
//         List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
//         System.out.println("---得到差集 reduce1 (list1 - list2)---");
//         reduce1.parallelStream().forEach(System.out :: println);
         List<Long> list3 = new ArrayList();
         list3.add(111l);
         list3.add(222l);
         list3.add(333L);
         
         List<Long> list4 = new ArrayList();
         list4.add(111l);
         list4.add(222l);
         List<Long> reduce2 = list3.stream().filter(item -> !list4.contains(item)).collect(Collectors.toList());
         System.out.println("---得到差集 reduce1 (list1 - list2)---");
         List<Long> list5 = new ArrayList();
         reduce2.parallelStream().forEach(item -> list5.add(item));
         System.out.println(list5);
    }
}