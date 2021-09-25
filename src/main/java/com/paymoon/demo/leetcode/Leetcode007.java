package com.paymoon.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 整数反转 简单 。
 * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
 * 与 10 取模，再与 10 相除取整，往复循环直至目标值为 0
 * 意识：数字类型是有可能溢出的。
 * 思路：让我们一起啃算法----整数反转 
 *         https://learnku.com/articles/43092
 */
class Leetcode007 {
	public int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			//与 10 取模，再与 10 相除取整，往复循环直至目标值为 0
			 //意识：数字类型是有可能溢出的。
			//这个条件放这里很迷。。1. 放下面编译不通过，2.最大是：2147483647，乘以10，可以保证
			if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
				return 0;
			}
			int digit = x % 10;
			x /= 10;
			rev = rev * 10 + digit;
		}
		return rev;
	}
public static void main(String[] args) {
	System.out.println(new Leetcode007().reverse(2147483647));
}
}
