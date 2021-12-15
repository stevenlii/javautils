package com.paymoon.demo.leetcode;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"val\":\"");
		builder.append(val);
		builder.append("\", \"left\":\"");
		builder.append(left);
		builder.append("\", \"right\":\"");
		builder.append(right);
		builder.append("\" }");
		return builder.toString();
	}
	
}