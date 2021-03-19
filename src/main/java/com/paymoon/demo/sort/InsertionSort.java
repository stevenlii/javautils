package com.paymoon.demo.sort;

/**
 * 插入排序、折半插入排序
 *
 */
public class InsertionSort  implements ISort {
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
		ISort.printArray(arr);

		// 排序
//		insertion_sort(arr);
		// 折半排序
		binaryInsertSort(arr);
		System.out.println("升序排序后：");

		// 排序后：
		ISort.printArray(arr);

	}

	/**
	 * https://zh.wikipedia.org/wiki/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F#cite_note-1
	 *  向有序序列中插入元素，那么插入位置可以不断地平分有序序列，并把待插入的元素的关键字与平分有序序列的关键字比较，以确定下一步要平分的子序列，直到找到合适的插入位置位置。
	 * @param arr
	 * @return
	 */
	private static void insertion_sort(int arr[]) {
		int i, j, currentIndex;
		int len = arr.length;
		for (i = 1; i != len; ++i) {
			currentIndex = arr[i];
			j = i - 1;
			while ((j >= 0) && (arr[j] > currentIndex)) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = currentIndex;
		}
	}

	/**
	 * 折半插入排序算法是一种稳定的排序算法，比直接插入算法明显减少了关键字之间比较的次数，因此速度比直接插入排序算法快，但记录移动的次数没有变，所以折半插入排序算法的时间复杂度仍然为O(n^2)，与直接插入排序算法相同。
	 * 折半插入排序
	https://blog.csdn.net/jabezlee/article/details/7757612
	 * @param array
	 */
	private static void binaryInsertSort(int array[]) {
		for (int i = 1; i < array.length; i++) {
			int currentIndex = array[i];

			int low = 0;

			int high = i - 1;
			// while 这段作用就是找到临界替换的下标了，low代表的值，正好刚刚大于i代表的值。从i到low，就是要换的数的下标
			// 如： 1[0] 3[1] 5[2] 9[3] 13[4]
			// 8[5]，当currentIndex=8时，下标[5]，low是下标[3],即9。high是下标[2],即5
			while (low <= high) {
				int mid = (low + high) / 2;

				if (currentIndex < array[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}

			for (int j = i; j >= low + 1; j--) {
				array[j] = array[j - 1];
			}

			array[low] = currentIndex;

		}
	}


	@Override
	public void sort(int[] arr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void whoIm() {
		System.out.println("插入排序、折半插入排序");
	}
}