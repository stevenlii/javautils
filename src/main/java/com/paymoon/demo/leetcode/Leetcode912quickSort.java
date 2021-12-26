package com.paymoon.demo.leetcode;

import java.util.Random;

public class Leetcode912quickSort {
	public int[] sortArray(int[] nums) {
		randomizedQuicksort(nums, 0, nums.length - 1);
		return nums;
	}

	public void randomizedQuicksort(int[] nums, int low, int high) {
		if (low < high) {
			//先排序
			int pos = randomizedPartition(nums, low, high);
			System.out.println("randomizedPartition :");
			pringArray(nums);
			//后递归
			randomizedQuicksort(nums, low, pos - 1);
			randomizedQuicksort(nums, pos + 1, high);
		}
	}
/**
 * 
 * @param nums
 * @param low 开始index
 * @param high 结束index
 * @return 被选中的数字v
 */
public int randomizedPartition(int[] nums, int low, int high) {
		int randomNum = new Random().nextInt(high - low + 1) + low; // 随机选一个作为我们的主元
		System.out.println("主元索引 "+randomNum +"  , 值是："+ nums[randomNum]);
		swap(nums, high, randomNum);
		return partition(nums, low, high);
	}

	public int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low - 1;
		for (int j = low; j <= high - 1; ++j) {
			if (nums[j] <= pivot) {
				i = i + 1;//i++;
				swap(nums, i, j);
			}
		}
		swap(nums, i + 1, high);
		return i + 1;
	}
	// nums数据里面 元素i,j互换
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		System.out.println("swapnums :");
		pringArray(nums);
	}

	public static void main(String[] args) {
		Leetcode912quickSort ltcd = new Leetcode912quickSort();
		int[] intArr = new int[] { 3, 5, 1, 8, 2, 0, 5, 9, 4, 2 };
		pringArray(intArr);
		ltcd.sortArray(intArr);
		System.out.println();
		pringArray(intArr);

	}

	public static void pringArray(int[] intArr) {
		for (int i = 0; i < intArr.length; i++) {
			System.out.print(intArr[i] + " ");
		}
		System.out.println();
	}
}
