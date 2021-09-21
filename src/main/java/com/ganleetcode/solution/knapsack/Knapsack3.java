package com.ganleetcode.solution.knapsack;

import java.util.Arrays;

/**
 * 0-1背包动态规划 空间复杂度优化
 */
public class Knapsack3
{
    public int knapsack01(int[] w, int[] v, int C) {
        assert w.length == v.length;
        int n = v.length;
        if (n == 0) {
            return 0;
        }
        int[][] mem = new int[2][C + 1];
        Arrays.fill(mem, -1);
        for (int j = 0; j < C + 1; j++) {
            mem[0][j] = j >= w[0] ? v[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < C + 1; j++) {
                if (j >= w[i]) {
                    mem[i % 2][j] = Math.max(mem[(i - 1) % 2][j], v[i] + mem[(i - 1) % 2][j - w[i]]);
                } else {
                    mem[i % 2][j] = mem[(i - 1) % 2][j];
                }
            }
        }
        return mem[(n - 1) % 2][C];
    }
}
