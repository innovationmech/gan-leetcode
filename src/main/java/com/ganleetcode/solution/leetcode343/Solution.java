package com.ganleetcode.solution.leetcode343;

import java.util.Arrays;

public class Solution
{

    public int integerBreak(int n) {
        assert n > 1;
        int[] mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解mem[i]
            for (int j = 1; j <= i - 1; j++) {
                mem[i] = Math.max(mem[i], Math.max(j * (i - j), j * mem[i - j]));
            }
        }
        return mem[n];
    }


}
