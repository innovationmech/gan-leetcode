package com.ganleetcode.solution.basicalg;

import com.ganleetcode.solution.common.TreeNode;
import java.util.Stack;

public class DFS
{
    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();

            System.out.println(treeNode.val);

            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }


}
