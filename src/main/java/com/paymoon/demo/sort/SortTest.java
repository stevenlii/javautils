package com.paymoon.demo.sort;

import org.junit.Test;

/**
 * 排序方法测试
 */
public class SortTest {
	@Test
	public void sort() {
		int[] arr = { 90, 11, 10, 45, 34, 88 };
		// 排序前；
		System.out.println("原数组：");
		ISort.printArray(arr);
		ISort bubbleISort = new BubbleSort();
		bubbleISort.whoIm();
		bubbleISort.sort(arr);
		System.out.println("升序排序后：");
		System.out.println();
		// 排序后：
		ISort.printArray(arr);
		
	}
	


}