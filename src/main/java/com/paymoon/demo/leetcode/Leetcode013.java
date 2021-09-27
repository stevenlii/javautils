package com.paymoon.demo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode013 {
	//先写一个map，然后每个字母循环，如果比后面对应的值小就先减，否则就加
	Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
        	char charValue = s.charAt(i);
            int value = symbolValues.get(charValue);
            if (i < n - 1 && value < symbolValues.get(s.charAt(i+1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }


	public static void main(String[] args) {
//		System.out.println(new Leetcode013().romanToInt("CCCLXV"));
//		System.out.println(new Leetcode013().romanToInt("IV"));
		System.out.println(new Leetcode013().romanToInt("CM"));
	}
}
