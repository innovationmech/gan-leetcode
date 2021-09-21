package com.ganleetcode.solution.leetcode46;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums, res, path, 0, len, used);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, int depth, int len, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, res, path, depth + 1, len, used);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

}
