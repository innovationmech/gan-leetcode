package com.ganleetcode.solution.leetcode814;

import com.ganleetcode.solution.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Solution
{
    public TreeNode pruneTree(TreeNode root)
    {
        if (!helper(root)) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode treeNode = queue.poll();
            if (helper(treeNode.left))
            {
                queue.add(treeNode.left);
            }
            else
            {
                treeNode.left = null;
            }
            if (helper(treeNode.right))
            {
                queue.add(treeNode.right);
            }
            else
            {
                treeNode.right = null;
            }
        }
        return root;
    }

    private boolean helper(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.val == 1) {
            return true;
        }
        return helper(node.left) || helper(node.right);
    }
}
