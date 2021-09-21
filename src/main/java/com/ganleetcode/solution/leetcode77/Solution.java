package com.ganleetcode.solution.leetcode77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution
{
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        res.clear();
        if (k <= 0 || k > n) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path);
        return res;
    }

    public void dfs(int n, int k, int start, Deque<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args)
    {
        Solution solution = new Solution();
        solution.combine(4, 2);
        System.out.println(solution.res.size());
    }



}

