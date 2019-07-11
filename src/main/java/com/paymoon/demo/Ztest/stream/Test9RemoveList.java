package com.paymoon.demo.Ztest.stream;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test8RemoveList {
    public static void main(String[] args) {

// Create a list.
        final List<Person> customers = Arrays.asList(
                new Person(1, "haha", 3),
                new Person(2, "rere", 3),
                new Person(13, "fefe", 4)
        );

        // Turn into a list of Ids.
        String keyi = 1 + "_" + "haha_" + "3";
        System.out.println(keyi);
        Map<String, List<Person>> processBizTypeMap3 = customers.stream().collect(Collectors.groupingBy(t -> t.getId() + "_" + t.getName() + "_" + t.getAge()));
        processBizTypeMap3.remove(keyi);

        boolean ids = processBizTypeMap3.removeIf(ttttt -> {
          return   (ttttt.getId() + "_" + ttttt.getName() + "_" + ttttt.getAge()).equals(keyi);
        });
//        boolean ids = customers.removeIf(ttttt -> {
//          return   (ttttt.getId() + "_" + ttttt.getName() + "_" + ttttt.getAge()).equals(keyi);
//        });
        System.out.println("Ids = " + ids);
        System.out.println(customers);

    }
    public static void remove13(List<String> list, String target){
        int size = list.size();
        for(int i = size - 1; i >= 0; i--){
            String item = list.get(i);
            if(target.equals(item)){
                list.remove(item);
            }
        }
        print(list);
    }
}