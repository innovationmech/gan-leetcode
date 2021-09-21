package com.ganleetcode.solution.leetcode437;

import com.ganleetcode.solution.common.TreeNode;

public class Solution
{
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        res += helper(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return res;
    }

    private int helper(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (root.val == targetSum) {
            result++;
        }
        result += helper(root.left, targetSum - root.val);
        result += helper(root.right, targetSum - root.val);
        return result;
    }

    public static void main(String[] args)
    {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        Solution solution = new Solution();
        System.out.println(solution.pathSum(root, 8));
    }
}
