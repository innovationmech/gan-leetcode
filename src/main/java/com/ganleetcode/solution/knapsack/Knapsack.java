package com.ganleetcode.solution.knapsack;

import java.util.Arrays;

/**
 * 0-1背包问题记忆化搜索
 */
public class Knapsack
{
    int[][] mem;

    public int knapsack01(int[] w, int[] v, int C) {
        int n = v.length;
        mem = new int[n][C + 1];
        Arrays.fill(mem, -1);
        return bestValue(w, v, n - 1, C);
    }

    // 用[0, index]的物品，填充容积为C的的背包的最大价值
    private int bestValue(int[] w, int[] v, int index, int C) {
        if (index < 0 || C <= 0) {
            return 0;
        }
        if (mem[index][C] != -1) {
            return mem[index][C];
        }
        int res = bestValue(w, v, index - 1, C);
        if (C >= w[index]) {
            res = Math.max(res, v[index] + bestValue(w, v, index -1, C - w[index]));
        }
        mem[index][C] = res;
        return res;
    }
}
