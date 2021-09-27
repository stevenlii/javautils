package com.paymoon.demo.leetcode;

/**
 * 盛最多水的容器 思路：本质上还是动态规划，只不过假设左边是1，那边右边没必要一直动了，因为容量还是限定在1. 所以就双指针了。
 * 官方：https://leetcode-cn.com/problems/container-with-most-water/solution/si-wei-dao-tu-zheng-li-shuang-zhi-zhen-d-tkx5/
 */
class Leetcode011 {
	//本质上还是动态规划，只不过假设左边是1，那边右边没必要一直动了，因为容量还是限定在1. 所以就双指针了。
	public int maxArea(int[] height) {
		int l = 0, r = height.length - 1;
		int ans = 0;
		while (l < r) {
			int area = Math.min(height[l], height[r]) * (r - l);
			ans = Math.max(ans, area);
			if (height[l] <= height[r]) { // 移动较小的那一端
				++l;
			} else {
				--r;
			}
		}
		return ans;
	}
}