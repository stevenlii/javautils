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
public class Java8Reduce3 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		ArrayList<Integer> identity = new ArrayList<Integer>();
		BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> accumulator = new biFunctionImpl();
		BinaryOperator<ArrayList<Integer>> combiner = new BinaryOperatorImpl();
//		ArrayList<Integer> accResult = Stream.of(8, 3, 9, 1).reduce(identity, accumulator, combiner);
//		System.out.println("-----accResult: " + accResult);
		ArrayList<Integer> accResult2 = Stream.of(8, 3, 9, 1).parallel().reduce(identity, accumulator, combiner);
		System.out.println("-----accResult: " + accResult2);
	}

}

class biFunctionImpl implements BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> {
	@Override
	public ArrayList<Integer> apply(ArrayList<Integer> acc, Integer item) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(item);
		System.out.println("---accumulator-----acc : " + acc + ", item:" + item);
		return result;
	}
}

class BinaryOperatorImpl implements BinaryOperator<ArrayList<Integer>> {
	@Override
	public ArrayList<Integer> apply(ArrayList<Integer> acc, ArrayList<Integer> item) {
		ArrayList<Integer> result = new ArrayList<Integer>();
//		result.addAll(item);
		System.out.println("combiner-----acc : " + acc + ", item:" + item);
		return result;
	}
}
