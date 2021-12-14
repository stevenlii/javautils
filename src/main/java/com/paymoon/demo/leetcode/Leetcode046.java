package com.paymoon.demo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode046 {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		List<Integer> output = new ArrayList<Integer>();
		for (int num : nums) {
			output.add(num);
		}

		int n = nums.length;
		backtrack(n, output, res, 0);
		return res;
	}

	public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
		// 所有数都填完了
		if (first == n) {
			res.add(new ArrayList<Integer>(output));
		}
		for (int i = first; i < n; i++) {
			// 动态维护数组
			Collections.swap(output, first, i);
			// 继续递归填下一个数n 1, n 2
			// n 1 
			backtrack(n, output, res, first + 1);
			// 撤销操作
			Collections.swap(output, first, i);
		}
	}

	public static void main(String[] args) {
		Leetcode046 leetcode046 = new Leetcode046();
		List<List<Integer>> res = leetcode046.permute(new int[] { 1, 2, 3 });
		System.out.println(res);
	}

}
