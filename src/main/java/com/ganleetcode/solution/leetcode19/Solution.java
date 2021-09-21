package com.ganleetcode.solution.leetcode19;

import com.ganleetcode.solution.common.ListNode;

public class Solution
{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q = p;
        while (n != 0) {
            q = q.next;
            n--;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;

        ListNode res = dummyHead.next;
        dummyHead.next = null;
        return res;
    }
}
