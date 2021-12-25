package com.ganleetcode.solution.leetcode1609;

import com.ganleetcode.solution.common.TreeNode;
import java.util.Deque;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Pair<TreeNode, Integer> first = new Pair<>(root, 0);
        queue.add(first);
        int left = root.val;
        int L = -1;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int level = pair.getValue();
            if (level % 2 == 0) {
                if (node.val % 2 == 0) {
                    return false;
                }
                if (L < level) {
                    L++;
                } else if (L == level && node.val <= left){
                    return false;
                }
            } else {
                if (node.val % 2 != 0) {
                    return false;
                }
                if (L < level) {
                    L++;
                } else if (L == level && node.val >= left) {
                    return false;
                }
            }
            left = node.val;
            if (node.left != null) {
                queue.add(new Pair<>(node.left, level + 1));
            }
            if (node.right != null) {
                queue.add(new Pair<>(node.right, level + 1));
            }
        }
        return true;
    }
}
