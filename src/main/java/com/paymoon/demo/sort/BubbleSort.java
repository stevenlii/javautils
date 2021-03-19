package com.paymoon.demo.sort;

/**
 * 冒泡排序 - 维基百科，自由的百科全书
https://zh.wikipedia.org/wiki/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F#JAVA */
public class BubbleSort implements ISort {
//先安排大数
	public void sort(int arr[]) {

		int i, j, temp;
		int len = arr.length;
		Boolean exchanged = true;

		for (i = 0; exchanged
				&& i < len - 1; i++) { /*
										 * 外迴圈為排序趟數，len個數進行len-1趟,只有交換過,exchanged值為true才有執行迴圈的必要,否則exchanged值為false不執行迴圈
										 */
			exchanged = false;
			for (j = 0; j < len - 1 - i; j++) { /* 內迴圈為每趟比較的次數，第i趟比較len-i次 */
				if (arr[j] > arr[j + 1]) { /* 相鄰元素比較，若逆序則互換（升序為左大於右，逆序反之） */
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					exchanged = true; /* 只有數值互換過, exchanged才會從false變成true,否則數列已經排序完成,exchanged值仍然為false,沒必要排序 */
				}
			}
		}
	}

	@Override
	public void whoIm() {
		System.out.println("冒泡排序");
	}

}