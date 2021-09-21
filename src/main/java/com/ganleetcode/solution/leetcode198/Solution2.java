package com.ganleetcode.solution.leetcode198;

import java.util.Arrays;

public class Solution2
{
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] mem = new int[n];
        Arrays.fill(mem, -1);
        mem[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                mem[i] = Math.max(mem[i], nums[j] + (j + 2 < n ? mem[j + 2] : 0));
            }
        }
        return mem[0];
    }
}
