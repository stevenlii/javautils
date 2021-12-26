package com.paymoon.demo.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Leetcode020 {
	//1. 是栈，用了栈
	public boolean isValid(String s) {
		int n = s.length();
		//2. 奇数直接false
		if (n % 2 == 1) {
			return false;
		}
		//3. 以右结点为key，左结点为value（value用来和stack比较）
		Map<Character, Character> pairs = new HashMap<Character, Character>() {
			{
				put(')', '(');
				put(']', '[');
				put('}', '{');
			}
		};
		//4. stack的push是放一个元素，pop是取一个元素并删除，peek是取出没删除
		Deque<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);
			//如果是左元素，放stack，如果当前是右元素（map判断），且stack peek后（拿出上一次的元素）和map 相应右元素相等，则为对称结构，此时pop
			//否则直接false
			if (pairs.containsKey(ch)) {
				if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
					return false;
				}
				stack.pop();
			} else {
				stack.push(ch);
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
//		System.out.println(new Leetcode020().isValid("[{](})"));
		System.out.println(new Leetcode020().isValid("[()]"));
	}
}
