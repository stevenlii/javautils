package com.paymoon.demo.java8.stream;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author MC Java 8系列之Stream中万能的reduce - 行云间 - CSDN博客
 *         https://blog.csdn.net/IO_Field/article/details/54971679 
 java8
 *         reduce方法中的第三个参数combiner有什么作用？ - 知乎
 *         https://www.zhihu.com/question/35451347?q=Stream%20%E7%9A%84%20reduce
 *         PS：第三个参数在accResult2里面就可以看到
 */
public class Java8Reduce4 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		//T reduce(T identity, BinaryOperator<T> accumulator);
        System.out.println("给定个初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (sum, item) -> sum + item));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::sum));
        System.out.println("给定个初始值，求min");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (min, item) -> Math.min(min, item)));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::min));
        System.out.println("给定个初始值，求max");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, (max, item) -> Math.max(max, item)));
        System.out.println(Stream.of(1, 2, 3, 4).reduce(100, Integer::max));
 
        //Optional<T> reduce(BinaryOperator<T> accumulator);
        // 注意返回值，上面的返回是T,泛型，传进去啥类型，返回就是啥类型。
        // 下面的返回的则是Optional类型
        System.out.println("无初始值，求和");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::sum).orElse(0));
        System.out.println("无初始值，求max");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::max).orElse(0));
        System.out.println("无初始值，求min");
        System.out.println(Stream.of(1, 2, 3, 4).reduce(Integer::min).orElse(0));
	}

}

