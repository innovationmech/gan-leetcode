package com.ganleetcode.solution.offer55;

import com.ganleetcode.solution.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class Solution
{
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        if (!isBalanced(root.left) || !isBalanced(root.right)) {
            return false;
        }
        return true;
    }

    private int height(TreeNode root) {
        int res = 0;
        if (root == null) {
            return res;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Pair<TreeNode, Integer> rootPair = new Pair<>(root, 1);
        queue.add(rootPair);
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            res = pair.getValue();
            if(pair.getKey().left != null) {
                queue.add(new Pair<>(pair.getKey().left, res + 1));
            }
            if (pair.getKey().right != null) {
                queue.add(new Pair<>(pair.getKey().right, res + 1));
            }
        }
        return res;
    }
}
