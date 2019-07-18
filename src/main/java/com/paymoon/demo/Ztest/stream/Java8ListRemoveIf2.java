package com.paymoon.demo.Ztest.stream;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8ListRemoveIf2 {
    public static void main(String[] args) {

// Create a list.
        List<Person> customers = new ArrayList();
        customers.add(new Person(1, "haha",3));
        customers.add(new Person(2, "rere",3));
        customers.add(new Person(13, "fefe",4));

        // Turn into a list of Ids.
        String keyi = 1 + "_" + "haha_" + "3";
        System.out.println(keyi);
        Map<String, List<Person>> processBizTypeMap3 = customers.stream().collect(Collectors.groupingBy(t -> t.getId() + "_" + t.getName() + "_" + t.getAge()));
        processBizTypeMap3.remove(keyi);

//        boolean ids = customers.removeIf(ttttt -> {
//          return   (ttttt.getId() + "_" + ttttt.getName() + "_" + ttttt.getAge()).equals(keyi);
//        });
//        System.out.println("Ids = " + ids);
//        System.out.println(customers);

    }
}