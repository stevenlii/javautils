package com.paymoon.demo.Ztest.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8ListRemoveIf3 {
    public static void main(String[] args) {

// Create a list.
         List<Person> customers = Arrays.asList(
                new Person(1, "haha", 3),
                new Person(2, "rere", 3),
                new Person(13, "fefe", 4)
        );

        // Turn into a list of Ids.
        String keyi = 1 + "_" + "haha_" + "3";
        System.out.println(keyi);
        System.out.println(customers);
        remove13(customers,keyi);
        System.out.println(customers);

    }
    public static void remove13(List<Person> list, String target){
        int size = list.size();
        for(int i = size - 1; i >= 0; i--){
            Person t = list.get(i);
            if(target.equals(t.getId() + "_" + t.getName() + "_" + t.getAge())){
                list.remove(t);
            }
        }
    }
}