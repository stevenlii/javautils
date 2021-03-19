package com.paymoon.demo.sort;

/**
 * 排序算法 - 维基百科，自由的百科全书
https://zh.wikipedia.org/wiki/%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95
 */
public interface ISort {

	void sort(int arr[]);

	void whoIm();

	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int x = 0; x < arr.length; x++) {
			if (x != arr.length - 1)
				System.out.print(arr[x] + ", ");
			else
				System.out.println(arr[x] + "]");

		}
	}
}