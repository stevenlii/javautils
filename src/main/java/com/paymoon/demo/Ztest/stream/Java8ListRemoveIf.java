package com.paymoon.demo.Ztest.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8ListRemoveIf {
    public static void main(String[] args) {

// Create a list.
        List<Person> customers = new ArrayList();
        customers.add(new Person(1, "haha",11));
        customers.add(new Person(2, "rere",22));
        customers.add(new Person(3, "fefe",33));

        Person p4 = new Person(4, "fefe",44);

        // Turn into a list of Ids.
        String keyi = 1 + "_" + "haha_" + "11";
        System.out.println(keyi);
        boolean isRmOk = customers.removeIf(t ->(t.getId() + "_" + t.getName() + "_" + t.getAge()).equals(keyi));
        System.out.println("isRmOk = " + isRmOk);
        customers.add(p4);
        System.out.println(customers);

    }
}