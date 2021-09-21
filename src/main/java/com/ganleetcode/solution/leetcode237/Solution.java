package com.ganleetcode.solution.leetcode237;

import com.ganleetcode.solution.common.ListNode;

public class Solution
{
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode delNode = node.next;
        node.next = delNode.next;
        delNode.next = null;
    }
}
