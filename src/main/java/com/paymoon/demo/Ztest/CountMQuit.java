package com.paymoon.demo.Ztest;

import java.util.ArrayList;
import java.util.List;
/**
 * 时间复杂度O(n)
 * @author stephenlii
 *
 */
public class CountMQuit {
 
	public static void main(String[] args) {
		int[] generateArray = null;
		int arrayLen = 10;
		int m = 4;
		generateArray = generateArray(arrayLen);
		System.out.println("generate Array,lenth is: "+arrayLen);
		for (int i = 0; i < generateArray.length; i++) {
			System.out.print(generateArray[i] + " ");
		}
		System.out.println();
		System.out.println("count "+m+"  then quit...");
		List<Integer> leftNumArray= countMQuit(generateArray,m);
		System.out.println("the one who is be left finally is:");
		System.out.println(leftNumArray);
	}
 
	public static int[] generateArray(int len) {
		int[] group500;
		group500 = new int[len];
		for (int i = 0; i < len; i++) {
			group500[i] = i;
		}
		return group500;
	}
 
	public static List<Integer> countMQuit(int[] generateArray,int m) {
		int leftNum = generateArray.length;// 留下人的数目
		for (int i = 0, j = 1;; i++) {
			if (i == generateArray.length) {
				i = 0;
			}
			if (generateArray[i] == -1) {
				continue;
			}
 
			if (j == m) {// in fact, when group[i] is quit, the
											// program should continue(skip).
				System.out.println(i + " is quit...");
				generateArray[i] = -1;
				leftNum--;
				if (leftNum < m) {
					break;
				}
				j = 1;
				i++;
			}
			if (i == generateArray.length) {
				i = 0;
			}
			if (generateArray[i] == -1) {// 应该写在j前，只要group[i] == 0，j就不应该加1
				continue;
			}
			j++;
		}
		List<Integer> leftNumIndex = new ArrayList<>(m - 1);
		for (int i = 0; i < generateArray.length; i++) {
			if (generateArray[i] != -1) {
				leftNumIndex.add(i);
			}
		}
		return leftNumIndex;
	}
 
}