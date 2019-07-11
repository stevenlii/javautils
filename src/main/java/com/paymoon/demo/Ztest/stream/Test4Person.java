package com.paymoon.demo.Ztest.stream;

import java.util.ArrayList;
import java.util.List;

public class Test4Person {
    public static void main(String[] args) {

        Person p = new Person(1, "aabb", 3);
        List<Person> personList = new ArrayList<>();
        Test4Person t = new Test4Person();
        System.out.println("start p is :" + p);
        Person p2 = t.getPersion(p);
        System.out.println("end..p is :" + p);
        System.out.println("end..p2 is : " + p2);

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