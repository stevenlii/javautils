package com.paymoon.demo.leetcode;

import org.apache.ibatis.javassist.expr.NewArray;

public class Leetcode019 {
	//快慢指针法（双指针）
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode index1 = head, index2 = head;
		for (int i = 0; i < n; i++)
			index2 = index2.next; // 使得index1与index2之间间隔n-1个节点(保证快指针没得时候，慢指针的后区节点是要删除的节点，而不是慢指针被删除）
		if (index2 == null)
			return head.next; // 说明删除的是头节点
		while (index2.next != null) { // 将index2移至最后一个节点
			index2 = index2.next;
			index1 = index1.next;
		}
		index1.next = index1.next.next;
		return head;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}

		
		
	}
	public static void main(String[] args) {
		Leetcode019 l19 = new Leetcode019();
		ListNode list = l19.new ListNode(4);
		 list = l19.new ListNode(3,list);
		 list = l19.new ListNode(2,list);
		 list = l19.new ListNode(1,list);
		 System.out.println("---------before-----------");
		 System.out.println(list);
		 ListNode resListNode = new Leetcode019().removeNthFromEnd(list, 2);
		 System.out.println("---------after-----------");
		System.out.println(resListNode);
	}
}
