package com.paymoon.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode102 {
	public static void main(String[] args) {
		Leetcode102 leetcode = new Leetcode102();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		node.left.left.left = new TreeNode(8);
		System.out.println(leetcode.levelOrder(node));
	}
	/**
	 * 广度优先不难理解。
	 * 知识点：
	 * 1. TreeNode结构和用法。
	 * 2. ret的数据结构。
	 * 3. Queue的用法。
	 * 4 Queue的为空判断以及for循环的位置
	 * TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		node.left.left.left = new TreeNode(8);
		System.out.println(leetcode.levelOrder(node));
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (root == null) {
			return ret;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<Integer>();
			int currentLevelSize = queue.size();
			for (int i = 1; i <= currentLevelSize; ++i) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			ret.add(level);
		}

		return ret;
	}

}
