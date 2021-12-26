package com.paymoon.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode017 {
	// 数字到号码的映射
    private String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    // 路径
    private StringBuilder sb = new StringBuilder();

    // 结果集
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return res;
        backtrack(digits,0);
        return res;
    }

    // 回溯函数
    private void backtrack(String digits,int index) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        String val = map[digits.charAt(index)-'2'];
        for(char ch:val.toCharArray()) {
        	System.out.println(String.format("1---digits:%s,index:%s,sb:%s", digits,index,sb.toString()));

            sb.append(ch);
            backtrack(digits,index+1);
            System.out.println(String.format("2---digits:%s,index:%s,sb:%s", digits,index,sb.toString()));
            sb.deleteCharAt(sb.length()-1);
            System.out.println(String.format("3---digits:%s,index:%s,sb:%s", digits,index,sb.toString()));

        }
    }
public static void main(String[] args) {
	System.out.println(new Leetcode017().letterCombinations("2387"));
}
}
