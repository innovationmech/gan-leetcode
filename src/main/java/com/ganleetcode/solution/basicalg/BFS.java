package com.ganleetcode.solution.basicalg;

import com.ganleetcode.solution.common.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
    public void search(TreeNode node) {
        if (node == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        if (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.println(treeNode.val);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }
}
