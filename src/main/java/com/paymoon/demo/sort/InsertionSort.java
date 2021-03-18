package com.paymoon.demo.sort;

/**
 * 插入排序
 *
 */
public class InsertionSort {
	public static void main(String[] args) {

		int[] arr = { 90, 10, 11, 45, 34, 88 };
//        其中i=4的时候的执行回放如下
//        int[] arr={10,11,45,90,34,88}; 
//        10 11 45 90 90 88 i=4(34)
//        10 11 45 90 90 88 i=4(34) j=3 j--
//        10 11 45 45 90 88 i=4(34) j=2 
//        跳出while 执行arr[j+1] = key;
//        10 11 34 45 90 88
//        i=5 
//        10 11 34 45 90 90  
//        跳出while 执行arr[j+1] = key;
//        10 11 34 45 88 90 

		// 排序前；
		System.out.println("原数组：");
		printArray(arr);

		// 排序
//        insertionSort(arr);
		insertion_sort(arr);
		System.out.println("升序排序后：");

		// 排序后：
		printArray(arr);

	}

	/**
	 * https://zh.wikipedia.org/wiki/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F#cite_note-1
	 * @param arr
	 * @return
	 */
	private static int[] insertion_sort(int arr[]) {
		int i, j, key;
		int len = arr.length;
		for (i = 1; i != len; ++i) {
			key = arr[i];
			j = i - 1;
			while ((j >= 0) && (arr[j] > key)) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
		return arr;
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