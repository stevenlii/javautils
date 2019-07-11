package com.paymoon.demo.Ztest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {

        Person p = new Person(1, "aabb", 3);
        List<Person> personList = new ArrayList<>();
        Test4 t = new Test4();
        System.out.println("start p is :" + p);
        Person p2 = t.getPersion(p);
        System.out.println("end..p is :" + p);
        System.out.println("end..p2 is : " + p2);
        System.out.println(p);
        System.out.println(1111111);
        t.getPersion(personList);
        System.out.println("personList Before:" + personList);
        for (Person person : personList) {
            t.getPersion(person);
        }
        System.out.println("personList after:" + personList);
        System.out.println(personList);
    }

    public Person getPersion(Person person) {
//        person = new Person(1, "aabb", 222);
        person.setAge(222);
        return  person;
    }

    public void getPersion(List<Person> personList) {
        Person person = new Person(1, "aabb", 2);
        personList.add(person);
    }
}