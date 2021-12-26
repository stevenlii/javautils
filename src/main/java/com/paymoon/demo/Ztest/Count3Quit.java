package com.paymoon.demo.Ztest;
 
public class Count3Quit {
 
	public static void main(String[] args) {
		int[] group500 = null;
		System.out.println("generate Array... ");
		group500 = generateArray();
		System.out.println("generate Array successful... ");
		System.out.println("the Array length is: " + group500.length);
		System.out.println("the Array is:");
		for (int i = 0; i < group500.length; i++) {
			System.out.print(group500[i] + " ");
		}
		System.out.println();
		System.out.println("count 3 then quit...");
		System.out.println("the one who is be left finally is:");
		System.out.println(count3Quit(group500));
	}
 
	public static int[] generateArray() {
		int[] group500;
		group500 = new int[8];
		for (int i = 1; i <= group500.length; i++) {
			group500[i - 1] = i;
		}
		return group500;
	}
 
	public static int count3Quit(int[] group) {
		int quitNum = 0;// 退出人的数目
		for (int i = 0, j = 1;; i++) {
			if (i >= group.length) {
				i = i - group.length;
			}
			// System.out.println(group.length);
			if (group[i] == 0) {
				continue;
			}
 
			if (j == 3) {// in fact, when group[i] is quit, the
											// program should continue(skip).
				System.out.println(i + " is quit...");
				group[i] = 0;
				quitNum++;
				if (quitNum == group.length - 1) {
					break;
				}
				j = 1;
				i++;
			}
			if (i >= group.length) {
				i = i - group.length;
			}
			// System.out.println(group.length);
			if (group[i] == 0) {// 应该写在j前，只要group[i] == 0，j就不应该加1
				System.out.println(i + " is quit...");
				continue;
			}
			j++;
		}
		int leftNum = -1;// 最后留下来的号
		for (int i = 0; i < group.length; i++) {
			if (group[i] != 0) {
				leftNum = i;// 最后留下来的号
			}
		}
 
		return leftNum;
	}
 
}