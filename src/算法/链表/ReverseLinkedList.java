/**
 * 206-ReverseLinkedList
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * Created by SaiDiCaprio on 2020/6/8.
 * Copyright © 2020 SaiDiCaprio. All rights reserved.
 */

package 算法.链表;

public class ReverseLinkedList {
    //    Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        // 递归方式
        public ListNode reverseList(ListNode head) {
            // 边界条件
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = reverseList(head);
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        // 非递归方式
        public ListNode reverseList2(ListNode head) {
            // 边界条件
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = null;
            while (head.next != null) {
                ListNode tmpNode = head.next;
                head.next = newHead;
                newHead = head;
                head = tmpNode;
            }
            return newHead;
        }
    }
}
