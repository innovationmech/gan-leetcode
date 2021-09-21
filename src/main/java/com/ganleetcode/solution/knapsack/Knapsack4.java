package com.ganleetcode.solution.knapsack;

import java.util.Arrays;

public class Knapsack4
{
    public int knapsack01(int[] w, int[] v, int C) {
        assert w.length == v.length;
        int n = v.length;
        if (n == 0) {
            return 0;
        }
        int[] mem = new int[C + 1];
        Arrays.fill(mem, -1);
        for (int j = 0; j < C + 1; j++) {
            mem[j] = j >= w[0] ? v[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = C; j >= w[i]; j--) {
                mem[j] = Math.max(mem[j], v[i] + mem[j - w[i]]);
            }
        }
        return mem[C];
    }
}
