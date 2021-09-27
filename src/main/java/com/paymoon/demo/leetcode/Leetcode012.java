package com.paymoon.demo.leetcode;

public class Leetcode012 {
//365 = CCCLXV,寻找区间数据
	//在1，5中放4，9，在10，50中放40，90，在100，500中放400，900
	//因题目要求3999，所以到1000就可以了
	int[] values =     { 1000, 900, 500, 400, 100,   90,  50,  40,   10,   9,    5,   4,    1 };
	String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public String intToRoman(int num) {
		//
		StringBuffer roman = new StringBuffer();
		for (int i = 0; i < values.length; ++i) {
			int value = values[i];
			String symbol = symbols[i];
			while (num >= value) {
				num -= value;
				roman.append(symbol);
			}
			if (num == 0) {
				break;
			}
		}
		return roman.toString();
	}

	public static void main(String[] args) {
//		System.out.println(new Leetcode012().intToRoman(365));
		System.out.println(new Leetcode012().intToRoman(4));
	}
}
