package com.ganleetcode.solution.leetcode430;

import com.ganleetcode.solution.common.Node;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        // 记录链表的最后一个节点
        Node last = null;
        while (cur != null) {
            Node next = cur.next;
            //  如果有子节点，那么首先处理子节点
            if (cur.child != null) {
                Node lastNode = dfs(cur.child);
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;
                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    lastNode.next = next;
                    next.prev = lastNode;
                }
                // 将 child 置为空
                cur.child = null;
                last = lastNode;
            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }
}
