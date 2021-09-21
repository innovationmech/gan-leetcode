package com.ganleetcode.solution.leetcode203;

import com.ganleetcode.solution.common.ListNode;

public class Solution
{
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        dummyHead.next = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode del = cur.next;
                cur.next = del.next;
                del.next = null;
            } else {
                cur = cur.next;
            }
        }
        ListNode res = dummyHead.next;
        dummyHead.next = null;
        return res;
    }
}
