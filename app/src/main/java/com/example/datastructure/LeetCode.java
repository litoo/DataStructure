package com.example.datastructure;

public class LeetCode {


    /**
     * 203 remove-linked-list-elements
     */
//    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode prev = new ListNode(-1);
            prev.next = head;
            while (prev.next != null) {
                if (prev.next.val == val) {//可删除元素
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return head;
        }
    }
}
