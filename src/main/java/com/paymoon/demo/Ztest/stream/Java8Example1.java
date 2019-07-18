package com.paymoon.demo.Ztest.stream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Java8Example1 {
    public static void main(String[] args) {
        //3 apple, 2 banana, others 1
        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple",  "banana", "papaya");
        Map<String, Long> result =
                items.stream().collect(
                        Collectors.groupingBy(
                                t -> t.substring(0,1), Collectors.counting()
                        )
                );
        System.out.println(result);
        int i = 13;
        Map<String, List<String>> result2 =
                items.stream().filter(t -> !t.equals("apple")).collect(
                        Collectors.groupingBy(
                                t -> t
                        )
                );
        System.out.println("result2 = [" + result2 + "]");
    }
}