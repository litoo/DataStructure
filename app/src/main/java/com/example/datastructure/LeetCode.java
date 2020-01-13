package com.example.datastructure;

public class LeetCode {


    /**
     * 203 remove-linked-list-elements
     */
//    Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int[] arr) {
            if (arr == null || arr.length == 0)
                throw new IllegalArgumentException("arr must not be empty");
            this.val = arr[0];
            for (int i = 1; i < arr.length; i++) {

            }

        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode prev = dummyHead;
            while (prev.next != null) {
                if (prev.next.val == val) {//可删除元素
                    prev.next = prev.next.next;
                } else {
                    prev = prev.next;
                }
            }
            return dummyHead.next;
        }
    }

    //递归算法，头节点依次往后遍历
    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            ListNode ret = removeElements(head.next, val);
            if (head.val == val) {//头节点需要删除
                return ret;
            } else {
                head.next = ret;
                return head;
            }
        }
    }

    public void test() {
        Solution2 solution2 = new Solution2();
        int[] nums = {0, 1, 5, 4, 6, 7};
        solution2.removeElements(new ListNode(nums), 5);
    }

}
