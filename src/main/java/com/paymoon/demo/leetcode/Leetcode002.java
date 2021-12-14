package com.paymoon.demo.leetcode;

/**
 * 考查链表用法题目
 */
class Leetcode002 {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// 返回类型使用链表，链表创建必须有头和指针（尾）
		ListNode head = null, tail = null;
		// 初等数学进位
		int carry = 0;
		// 链表必须使用while
		while (l1 != null || l2 != null) {
			// 链表取值方法
			int num1 = l1 == null ? 0 : l1.val;
			int num2 = l2 == null ? 0 : l2.val;
			int sum = num1 + num2 + carry;
			if (head == null) {
				// sum % 10 ，留下个位数
				head = tail = new ListNode(sum % 10);
			} else {
				// 注意这里指针用法，先给next值，然后再让tail指向下一个节点
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			//此处记录进位
			carry = sum / 10;
			// 链表循环用法
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}

		}
		//最后进位的别忘了
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}

	public static void main(String[] args) {
	}
}
