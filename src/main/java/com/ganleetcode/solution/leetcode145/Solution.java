package com.ganleetcode.solution.leetcode145;

import com.ganleetcode.solution.common.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * todo
 *
 * @author <a href="dreamerlyj@gmail.com">liyanjie</a>
 * @since
 */
public class Solution
{
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Command> deque = new ArrayDeque<>();
        deque.push(new Command("go", root));
        while (!deque.isEmpty()) {
            Command command = deque.pop();
            if ("go".equals(command.order)) {
                deque.push(new Command("add", command.treeNode));
                if (command.treeNode.right != null) {
                    deque.push(new Command("go", command.treeNode.right));
                }
                if (command.treeNode.left != null) {
                    deque.push(new Command("go", command.treeNode.left));
                }
            } else if ("add".equals(command.order)) {
                res.add(command.treeNode.val);
            }
        }
        return res;
    }

    static class Command {
        String order;
        TreeNode treeNode;

        Command(String order, TreeNode treeNode) {
            this.order = order;
            this.treeNode = treeNode;
        }
    }
}
