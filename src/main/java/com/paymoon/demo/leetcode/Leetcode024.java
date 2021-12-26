package com.paymoon.demo.leetcode;

public class Leetcode024 {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}
	public static void main(String[] args) {
		ListNode list3 = new ListNode(1);
		ListNode list3sPrev = list3;
		list3sPrev.next =  new ListNode(2);
		list3sPrev = list3sPrev.next;
		list3sPrev.next =  new ListNode(3);
		list3sPrev = list3sPrev.next;
		list3sPrev.next =  new ListNode(4);
	
		ListNode resListNode = new Leetcode024().swapPairs(list3);
		System.out.println(resListNode);
	}
}
