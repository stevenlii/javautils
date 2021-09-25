package com.paymoon.demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 
 * @author stephenlii
 *
 */
class Leetcode006 {
	public String convert(String s, int numRows) {

		if (numRows == 1)
			return s;

		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++)
			rows.add(new StringBuilder());

		int curRow = 0;
		boolean goingDown = false;

		for (char c : s.toCharArray()) {
			rows.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1) {
				goingDown = !goingDown;
			}
			curRow += goingDown ? 1 : -1;
			System.out.println(String.format("curRow:%s,goingDown:%s", curRow, goingDown));
		}

		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows)
			ret.append(row);
		return ret.toString();
	}

	public static void main(String[] args) {
		// 这个算法我看得目瞪口呆，简直神了
		// 比如字符串：babadzyw。最终变成z型就是
		/**
		 * 
		 * <li>b   d</li>
		 * <li>a a z w</li>
		 * <li>b   y</li>
		 */
		//25行的算法：下标的变化是：0 -> 1 ->2 ->1 ->0 循环
		//然后输入字符串的映射下标是：
		//babadzyw
		//01210121
		//再把字符串按照下标，放成一组（总共3组，几行就是几组，需要和字符串长度做比较），即：
		// bd,aazw,by
		//再串起来
		// 最终输出结果为：b d a a z w b y
		//

		System.out.println(new Leetcode006().convert("babadzyw", 10));
	}
}
