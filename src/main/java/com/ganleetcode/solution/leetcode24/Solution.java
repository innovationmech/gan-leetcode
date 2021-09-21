package com.ganleetcode.solution.leetcode24;

import com.ganleetcode.solution.common.ListNode;

public class Solution
{
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode after = head.next;
        head.next = swapPairs(after.next);
        after.next = head;
        return after;
    }
}
