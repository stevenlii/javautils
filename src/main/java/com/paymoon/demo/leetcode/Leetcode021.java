package com.paymoon.demo.leetcode;

public class Leetcode021 {
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
	//迭代法，把链表集合到一个新的链表里面。
	//通过判断1和2的当前大小，哪个小就先入新链表
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		Leetcode021 l21 = new Leetcode021();
		ListNode prehead = l21.new ListNode(-1);

		ListNode prev = prehead;
		while (l1 != null && l2 != null) {
//			System.out.println(String.format("prev:%s,prehead:%s", prev,prehead));
			if (l1.val <= l2.val) {
				//这里和官方不同，且比官方的好
				prev.next = l21.new ListNode(l1.val );
				l1 = l1.next;
			} else {
				//这里和官方不同，且比官方的好
				prev.next =  l21.new ListNode(l2.val );
				l2 = l2.next;
			}
			prev = prev.next;
		}

		// 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
		prev.next = l1 == null ? l2 : l1;
//		System.out.println(String.format("last...prev:%s,prehead:%s", prev,prehead));
		return prehead.next;
	}

	public static void main(String[] args) {
		Leetcode021 l21 = new Leetcode021();
		/*以下是倒序插入链表方法*/
		ListNode list = l21.new ListNode(4);
		list = l21.new ListNode(2, list);
		list = l21.new ListNode(1, list);
		ListNode list2 = l21.new ListNode(4);
		list2 = l21.new ListNode(3, list2);
		list2 = l21.new ListNode(1, list2);
		/*以下是正序插入链表方法*/
		ListNode list3 = l21.new ListNode(1);
		ListNode list3sPrev = list3;
		list3sPrev.next =  l21.new ListNode(2);
		list3sPrev = list3sPrev.next;
		list3sPrev.next =  l21.new ListNode(4);
		ListNode list4 = l21.new ListNode(1);
		ListNode list4sPrev = list4;
		list4sPrev.next = l21.new ListNode(3);
		list4sPrev = list4sPrev.next;
		list4sPrev.next = l21.new ListNode(4);
	
		ListNode resListNode = l21.mergeTwoLists(list3, list4);
		System.out.println(resListNode);
	}
}
