package com.ganleetcode.solution.leetcode102;

import com.ganleetcode.solution.common.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javafx.util.Pair;

public class Solution
{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Pair<TreeNode, Integer> rootPair = new Pair<>(root, 0);
        queue.add(rootPair);
        int level = 0;
        List<Integer> firstList = new ArrayList<>();
        res.add(firstList);
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            List<Integer> list = res.get(level);
            if (pair.getValue() > level) {
                list = new ArrayList<>();
                res.add(list);
                level += 1;
            }
            list.add(pair.getKey().val);

            if (pair.getKey().left != null) {
                Pair<TreeNode, Integer> left = new Pair<>(pair.getKey().left, pair.getValue() + 1);
                queue.add(left);
            }
            if (pair.getKey().right != null) {
                Pair<TreeNode, Integer> right = new Pair<>(pair.getKey().right, pair.getValue() + 1);
                queue.add(right);
            }
        }
        return res;
    }
}
