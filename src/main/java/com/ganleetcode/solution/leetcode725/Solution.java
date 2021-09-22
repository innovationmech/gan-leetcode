package com.ganleetcode.solution.leetcode725;

import com.ganleetcode.solution.common.ListNode;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] listNodes = new ListNode[k];
        if (head == null) {
            return listNodes;
        }
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int average = len / k;
        int remain = len % k;
        ListNode p = head;
        for (int i = 0; i < k && p != null; i++) {
            listNodes[i] = p;
            int partSize = average + (i < remain ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                p = p.next;
            }
            ListNode next = p.next;
            p.next = null;
            p = next;
        }
        return listNodes;
    }
}
