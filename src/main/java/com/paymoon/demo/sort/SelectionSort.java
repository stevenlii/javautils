package com.paymoon.demo.sort;

/**
 * 选择排序
 *选择排序 - 维基百科，自由的百科全书
https://zh.wikipedia.org/wiki/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F
工作原理如下。首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
 */
public class SelectionSort {
	public static void main(String[] args) {

		int[] arr = { 90, 10, 11, 45, 34, 88 };
		// 排序前；
		System.out.println("原数组：");
		printArray(arr);

		selection_sort(arr);
		System.out.println("升序排序后：");

		// 排序后：
		printArray(arr);

	}

	/**
	 * https://zh.wikipedia.org/wiki/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F#cite_note-1
	 *  向有序序列中插入元素，那么插入位置可以不断地平分有序序列，并把待插入的元素的关键字与平分有序序列的关键字比较，以确定下一步要平分的子序列，直到找到合适的插入位置位置。
	 * @param arr
	 * @return
	 */
	public static void selectionSort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N - 1; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	static void selection_sort(int arr[]) {
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