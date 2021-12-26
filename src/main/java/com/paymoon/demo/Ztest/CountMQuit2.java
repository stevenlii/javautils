package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
/**
 * 时间复杂度O（n平方）
 * @author stephenlii
 *
 */
public class CountMQuit2 {

	public static void main(String[] args) {
		int arrayLen = 10;
		int m = 7;
		System.out.println("count " + m + "  then quit...");
		List<Integer> leftNumArray = countMQuit(arrayLen, m);
		System.out.println("the one who is be left finally is:");
		System.out.println(leftNumArray);
	}


	public static List<Integer> countMQuit(int generateArrayLength, int m) {
		ArrayList<Integer> generateArray = new ArrayList<>(generateArrayLength);
		for (int i = 0; i < generateArrayLength; i++) {
			generateArray.add(i);
		}
		int i = 0;
		while (generateArrayLength >= m) {
			//按照当前索引值：i +步长 % 总数，得到m
			i = (i + m - 1) % generateArrayLength;
			generateArray.remove(i);
			generateArrayLength--;
		}
		
		return generateArray;

	}
}