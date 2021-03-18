package com.paymoon.demo.sort;

/**
 * “深入理解”—插入排序算法_冷血之心的博客-CSDN博客
https://blog.csdn.net/qq_25827845/article/details/51728669
 *
 */
public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 38, 55, 65, 97, 27, 76 };
		Shell s = new Shell();
		s.shellsort(arr);
		// s.shellsort2(arr);
//       for(int a:arr)
//    	   System.out.println(a);
	}

}

class Shell {
	public void shellsort2(int[] a) {
		for (int d = a.length / 2; d > 0; d = d / 2) {
			System.out.println("d=" + d);
			for (int i = d; i < a.length; i++) {
				for (int j = i - d; j >= 0; j = j - d) {
					if (a[i] < a[j]) {
						int temp = a[i];
						a[i] = a[j];
						a[j] = temp;

					}

				}
			}

			for (int z : a)
				System.out.println(z);
		}

	}

	public void shellsort(int[] a) {
		for (int d = a.length / 2; d > 0; d = d / 2) {
			System.out.println("d=" + d);
			for (int i = d; i < a.length; i++) {
				int temp = a[i];
				int j;
				for (j = i - d; j >= 0 && temp < a[j]; j = j - d) {
					a[j + d] = a[j];
				}
				a[j + d] = temp;
			}
			for (int z : a)
				System.out.println(z);
		}
	}

}