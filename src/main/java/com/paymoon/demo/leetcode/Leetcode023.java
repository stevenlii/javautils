package com.paymoon.demo.leetcode;

public class Leetcode023 {
	 public ListNode mergeKLists(ListNode[] lists) {
	        ListNode ans = null;
	        for (int i = 0; i < lists.length; ++i) {
	            ans = mergeTwoLists(ans, lists[i]);
	        }
	        return ans;
	    }
	 //mergeTwoLists 是021题目
	    public ListNode mergeTwoLists(ListNode a, ListNode b) {
	        if (a == null || b == null) {
	            return a != null ? a : b;
	        }
	        ListNode head = new ListNode(0);
	        ListNode tail = head, aPtr = a, bPtr = b;
	        while (aPtr != null && bPtr != null) {
	            if (aPtr.val < bPtr.val) {
	                tail.next = aPtr;
	                aPtr = aPtr.next;
	            } else {
	                tail.next = bPtr;
	                bPtr = bPtr.next;
	            }
	            tail = tail.next;
	        }
	        tail.next = (aPtr != null ? aPtr : bPtr);
	        return head.next;
	    }

}
