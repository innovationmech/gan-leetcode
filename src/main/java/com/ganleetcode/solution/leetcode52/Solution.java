package com.ganleetcode.solution.leetcode52;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution
{
    int res = 0;

    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> main = new HashSet<>();
        Set<Integer> sub = new HashSet<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(path, col, main, sub, n, 0);
        return res;
    }

    public void dfs(Deque<Integer> path, Set<Integer> col, Set<Integer> main, Set<Integer> sub, int n, int row) {
        if (path.size() == n) {
            res++;
            return;
        }
        for (int j = 0; j < n; j++) {
            if(!col.contains(j) && !main.contains(row - j) && !sub.contains(row + j)) {
                path.add(j);
                col.add(j);
                main.add(row - j);
                sub.add(row + j);
                dfs(path, col, main, sub, n, row + 1);
                path.removeLast();
                col.remove(j);
                main.remove(row - j);
                sub.remove(row + j);
            }
        }
    }
}
