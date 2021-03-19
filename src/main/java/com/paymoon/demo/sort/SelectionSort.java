package com.paymoon.demo.sort;

/**
 * 选择排序
 *选择排序 - 维基百科，自由的百科全书
https://zh.wikipedia.org/wiki/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F
工作原理如下。首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort implements ISort {


	public void sort(int arr[]) {
		int i, j, temp;
		int len = arr.length;
		for (i = 0; i < len - 1; i++) {
			int min = i;
			for (j = i + 1; j < len; j++) // 走訪未排序的元素
			{
				if (arr[j] < arr[min]) // 找到目前最小值
				{
					min = j; // 紀錄最小值
				}
			}
			if (min != i) {
				temp = arr[min]; // 交換兩個變數
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
	}

	@Override
	public void whoIm() {
		System.out.println("选择排序");
	}

}